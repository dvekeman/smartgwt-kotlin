package sample.components

import isc.*
import kotlinx.html.id
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import kotlin.browser.document

/**
 * A React Component which shows the 'main' listgrid from the SmartGWT builtinds sample project.
 * This is a `connected` component:
 *
 * @see sample.containers.VisibleMainListGrid
 */

val ID = "main-listgrid"

interface MainListGridProps : RProps {
    /** Function to propagate an action which changes the datasource from the ListGrid **/
    var onChangeDataSource: (String) -> Unit
    var onStartEdit: () -> Unit
    var onFinishEdit: () -> Unit
    /** Current active DataSource name **/
    var dsName: String?
    /** E.g. when a new item is being created */
    var isDirty: Boolean
}

/**
 * `Stateless` React Component which renders the listgrid from the SmartGWT builtinds sample project.
 */
class MainListGrid(props: MainListGridProps) : RComponent<MainListGridProps, RState>(props) {

    private lateinit var saveBtn: isc.IButton
    private lateinit var newBtn: isc.IButton

    private val boundForm: isc.DynamicForm = isc.DynamicForm.create()
    private val boundList: isc.ListGrid = isc.ListGrid.create()
    private val boundViewer: isc.DetailViewer = isc.DetailViewer.create()

    private val mainLayout: isc.Layout = createMainLayoutR()

    override fun componentDidMount() {
        println("MainListGrid::componentDidMount")
        this.mainLayout.asDynamic().setHtmlElement(document.getElementById(ID))
        this.mainLayout.position = "relative"
        this.mainLayout.draw()
    }

    override fun componentWillUnmount() {
        println("MainListGrid::componentWillUnmount")
        this.mainLayout.clear()
    }

    override fun RBuilder.render() {
        println("MainListGrid::render with $props")
        if (props.dsName != null) {
            val ds = isc.DataSource.get(props.dsName!!)
            ds?.useHttpProxy = true
            if (ds?.requestProperties != null) {
                val requestProperties = ds.requestProperties
                val requestHeaders = requestProperties.httpHeaders
                requestHeaders.asDynamic()["Origin"] = "http://localhost:8088" // CORS Header for POC
                requestProperties.httpHeaders = requestHeaders
                ds.requestProperties = requestProperties
            }

            println("render:: DataSource: ${ds.asDynamic()}")

            boundList.asDynamic().setDataSource(ds)
            boundViewer.asDynamic().setDataSource(ds)
            boundForm.asDynamic().setDataSource(ds)
            boundList.fetchData()

            newBtn.enable()
        }

        saveBtn.setDisabled(!props.isDirty)

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
        
        grid.asDynamic().recordClick = { viewer: ListGrid, record: ListGridRecord, recordNum: Number, field: ListGridField, fieldNum: Number, value: Any, rawValue: Any ->
            val dsName = record.asDynamic().dsName
            this.props.onChangeDataSource(dsName as String)
        }

        return grid
    }

    private fun createBodyR(): isc.Layout {
        saveBtn = createSaveButton()
        newBtn = createButton("New")
        val clearBtn: isc.IButton = createButton("Clear")
        val filterBtn: isc.IButton = createButton("Filter")
        val fetchBtn: isc.IButton = createButton("Fetch")

        val vStack = isc.VStack.create()
        vStack.setWidth("70%")
        vStack.membersMargin = 20

        this.boundList.setHeight(200)
        this.boundList.canEdit = true

        this.boundList.asDynamic().recordClick = { viewer: ListGrid, record: ListGridRecord, recordNum: Number, field: ListGridField, fieldNum: Number, value: Any, rawValue: Any ->
            this.boundForm.editRecord(record)
            this.boundViewer.viewSelectedData(this.boundList)
            this.props.onStartEdit()
        }

        vStack.addMember(this.boundList)

        this.boundForm.numCols = 6
        this.boundForm.autoFocus = false
        vStack.addMember(this.boundForm)

        val hLayout = isc.HLayout.create()
        hLayout.membersMargin = 10
        hLayout.setHeight(22)


        hLayout.addMember(saveBtn)

        /* NEW Button */
        newBtn.asDynamic().click = {
            this.boundForm.editNewRecord()
            this.props.onStartEdit()
        }
        hLayout.addMember(newBtn)

        /* CLEAR Button */
        clearBtn.asDynamic().click = {
            this.boundForm.clearValues()
            this.props.onFinishEdit()
        }
        hLayout.addMember(clearBtn)

        /* FILTER Button */
        filterBtn.asDynamic().click = {
            this.boundList.filterData(boundForm.getValuesAsCriteria(false))
            this.props.onFinishEdit()
        }
        hLayout.addMember(filterBtn)

        /* FETCH Button */
        fetchBtn.asDynamic().click = {
            this.boundList.fetchData(boundForm.getValuesAsCriteria(false))
            this.props.onFinishEdit()
        }
        hLayout.addMember(fetchBtn)

        vStack.addMember(hLayout)
        vStack.addMember(this.boundViewer)
        return vStack
    }

    /**
     * SAVE Button
     */
    private fun createSaveButton(): isc.IButton {
        val saveBtn: isc.IButton = createButton("Save")
        saveBtn.asDynamic().click = {
            this.boundForm.saveData({ dsResponse: DSResponse, data: Any, dsRequest: DSRequest ->
                if (dsResponse.status == RPCResponse.STATUS_SUCCESS) {
                    // if the save succeeded, clear the UI
                    this.boundForm.clearValues()
                    saveBtn.disable()
                }
            }
            )
            true
        }
        return saveBtn
    }

    private fun createButton(title: String): isc.IButton {
        val button = isc.IButton.create()
        button.setTitle(title)
        return button
    }
}

fun RBuilder.mainListGrid(dsName: String?, onChangeDataSource: (String) -> Unit, onStartEdit: () -> Unit, onFinishEdit: () -> Unit) = child(MainListGrid::class) {
    attrs.dsName = dsName
    attrs.onChangeDataSource = onChangeDataSource
    attrs.onStartEdit = onStartEdit
    attrs.onFinishEdit = onFinishEdit
}

