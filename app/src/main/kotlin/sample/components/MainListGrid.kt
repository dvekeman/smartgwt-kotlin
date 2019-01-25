package sample.components

import isc.*
import kotlinx.html.id
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import kotlin.browser.document

val ID = "main-listgrid"

interface MainListGridProps : RProps {
    var onChangeDataSource: (String) -> Unit
    var dsName: String?
}

class MainListGrid(props: MainListGridProps) : RComponent<MainListGridProps, RState>(props) {

    private val boundForm: isc.DynamicForm = isc.DynamicForm.create()
    private val boundList: isc.ListGrid = isc.ListGrid.create()
    private val boundViewer: isc.DetailViewer = isc.DetailViewer.create()

    private val mainLayout: isc.Layout = createMainLayoutR()
    
    override fun componentDidMount() {
        this.mainLayout.asDynamic().setHtmlElement(document.getElementById(ID))
        this.mainLayout.position = "relative"
        this.mainLayout.draw()
    }

    override fun componentWillUnmount() {
        this.mainLayout.clear()
    }
    
    override fun RBuilder.render() {
        if (props.dsName != null) {
            val ds = isc.DataSource.get(props.dsName!!)
            ds?.useHttpProxy = true
            if (ds?.requestProperties != null) {
                val requestProperties = ds.requestProperties
                val requestHeaders = requestProperties.httpHeaders
                requestHeaders.asDynamic()["Origin"] = "http://localhost:8088"
                requestProperties.httpHeaders = requestHeaders
                ds.requestProperties = requestProperties
            }

            println("createBody:: DataSource: ${ds.asDynamic()}")

            boundList.asDynamic().setDataSource(ds)
            boundViewer.asDynamic().setDataSource(ds)
            boundForm.asDynamic().setDataSource(ds)
            boundList.fetchData()
        }
        
        div {
            // attributesMapOf("id", ID)
            attrs { id = ID }
        }
    }

    private fun createMainLayoutR(): isc.Layout {
        val mainLayout = isc.HLayout.create()
        val mainBody = createBodyR()
        val grid = createLeftMenuR()

        mainLayout.setWidth("100%")
        mainLayout.addMembers(arrayOf(grid, mainBody) as Array<Any?>)
        return mainLayout
    }

    private fun createLeftMenuR(): ListGrid {
        val m = isc.Menu.create()
        m.getOuterElement()

        val grid = isc.ListGrid.create()
        //		grid.setLeft(20);
        //		grid.setTop(75);
        grid.setWidth(130)
        grid.setHeight("100%")
        grid.leaveScrollbarGap = false
        grid.showSortArrow = "none"
        grid.canSort = false
        val dsTitleField: dynamic = object {}
        dsTitleField["name"] = "dsTitle"
        dsTitleField["title"] = "Select a DataSource"
        grid.setFields(arrayOf(dsTitleField))

        val dsAnimals: dynamic = object {}
        dsAnimals["dsTitle"] = "Animals"
        dsAnimals["dsName"] = "animals"

        val dsOffice: dynamic = object {}
        dsOffice["dsTitle"] = "Office Supplies"
        dsOffice["dsName"] = "supplyItem"

        val dsEmployees: dynamic = object {}
        dsEmployees["dsTitle"] = "Employees"
        dsEmployees["dsName"] = "employees"

        grid.setData(arrayOf(dsAnimals, dsOffice, dsEmployees))
        grid.setSelectionType("single")
        grid.asDynamic().recordClick =
                { viewer: ListGrid, record: ListGridRecord, recordNum: Number, field: ListGridField, fieldNum: Number, value: Any, rawValue: Any ->
                    val dsName = record.asDynamic().dsName
                    this.props.onChangeDataSource(dsName)
                }

        return grid
    }

    private fun createBodyR(): isc.Layout {
        val saveBtn: isc.IButton = isc.IButton.create(js("{'title': \"Save\"}") as Any)
        val newBtn: isc.IButton = isc.IButton.create(js("{'title': \"New\"}") as Any)
        val clearBtn: isc.IButton = isc.IButton.create(js("{'title': \"Clear\"}") as Any)
        val filterBtn: isc.IButton = isc.IButton.create(js("{'title': \"Filter\"}") as Any)
        val fetchBtn: isc.IButton = isc.IButton.create(js("{'title': \"Fetch\"}") as Any)
//    val boundForm: isc.DynamicForm = isc.DynamicForm.create()
//    val boundList: isc.ListGrid = isc.ListGrid.create()
//    val boundViewer: isc.DetailViewer = isc.DetailViewer.create()

        println("createBody:: create body for ${this.props.dsName}...")
        if(this.props.dsName != null){
            newBtn.enable()
            saveBtn.disable()

//        val ds = isc.DataSource.get(dsName)
//        ds?.useHttpProxy = true
//        if(ds?.requestProperties != null){
//            val requestProperties = ds.requestProperties
//            val requestHeaders = requestProperties.httpHeaders
//            requestHeaders.asDynamic()["Origin"] = "http://localhost:8088"
//            requestProperties.httpHeaders = requestHeaders
//            ds.requestProperties = requestProperties
//        }
//
//        println("createBody:: DataSource: ${ds.asDynamic()}")
//        boundList.asDynamic().setDataSource(ds)
//        boundViewer.asDynamic().setDataSource(ds)
//        boundForm.asDynamic().setDataSource(ds)
//        boundList.fetchData()

        }

        val vStack = isc.VStack.create()
        //		vStack.setLeft(175);
        //		vStack.setTop(75);
        vStack.setWidth("70%")
        vStack.membersMargin = 20

        this.boundList.setHeight(200)
        this.boundList.canEdit = true

        this.boundList.asDynamic().recordClick =
                { viewer: ListGrid, record: ListGridRecord, recordNum: Number, field: ListGridField, fieldNum: Number, value: Any, rawValue: Any ->
                    this.boundForm.editRecord(record)
                    saveBtn.enable()
                    this.boundViewer.viewSelectedData(this.boundList)
                }

        vStack.addMember(this.boundList)

        this.boundForm.numCols = 6
        this.boundForm.autoFocus = false
        vStack.addMember(this.boundForm)

        val hLayout = isc.HLayout.create(js(
                "{'membersMargin': 10 }"
        ) as? Any)
        hLayout.setHeight(22)

        saveBtn.asDynamic().click =
                {
                    this.boundForm.saveData(
                            { dsResponse: DSResponse, data: Any, dsRequest: DSRequest ->
                                if (dsResponse.status == RPCResponse.STATUS_SUCCESS) {
                                    // if the save succeeded, clear the UI
                                    this.boundForm.clearValues()
                                    saveBtn.disable()
                                }
                            }
                    )
                    true
                }

        hLayout.addMember(saveBtn)

        newBtn.asDynamic().click =
                {
                    this.boundForm.editNewRecord()
                    saveBtn.enable()
                }
        hLayout.addMember(newBtn)

        clearBtn.asDynamic().click =
                {
                    this.boundForm.clearValues()
                    saveBtn.disable()
                }
        hLayout.addMember(clearBtn)

        filterBtn.asDynamic().click =
                {
                    this.boundList.filterData(boundForm.getValuesAsCriteria(false))
                    saveBtn.disable()
                }
        hLayout.addMember(filterBtn)

        fetchBtn.asDynamic().click =
                {
                    this.boundList.fetchData(boundForm.getValuesAsCriteria(false))
                    saveBtn.disable()
                }
        hLayout.addMember(fetchBtn)

        vStack.addMember(hLayout)

        vStack.addMember(this.boundViewer)

        return vStack
        //vStack.draw();
    }
}

fun RBuilder.mainListGrid(dsName: String?, onChangeDataSource: (String) -> Unit) = child(MainListGrid::class) {
    attrs.dsName = dsName
    attrs.onChangeDataSource = onChangeDataSource
}

