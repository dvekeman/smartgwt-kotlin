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
 *
 * This is a `Presentational component`, from the Redux documentation:
 *
 * `Presentational components`
 * - how things look
 * - Not aware of Redux
 * - Read data from props
 * - Invoke callbacks from props
 *
 * (https://redux.js.org/basics/usage-with-react)
 *
 */

/**
 * A React Component which shows the 'main' listgrid from the SmartGWT builtinds sample project.
 * This is a `connected` component:
 *
 * @see sample.containers.VisibleMainListGrid
 *
 * Some notes about this implementation
 *
 * - The SmartClient code is intentionally in functions which are external to the React component
 * - The main layout is explicitly cleared and redrawn (intentionally) to similate a stateless setup
 *     - back side is that some thing don't work as expected (e.g. selecting a DataSource in the left grid: selected item gets lost)
 * -
 *
 */

val ID = "main-listgrid"

interface MainListGridProps : RProps {
    /** Function to propagate an action which changes the datasource from the ListGrid **/
    var onChangeDataSource: (String) -> Unit
    /** Current active DataSource name **/
    var dsName: String?
}

/**
 * `Stateless` React Component which renders the listgrid from the SmartGWT builtinds sample project.
 */
class MainListGrid(props: MainListGridProps) : RComponent<MainListGridProps, RState>(props) {

    private lateinit var mainLayout: isc.Layout

    override fun componentDidMount() {
        println("MainListGrid::componentDidMount")
        this.mainLayout = createMainLayout(props)
        connectAndDrawLayout()
    }

    override fun componentWillUnmount() {
        println("MainListGrid::componentWillUnmount")
        this.mainLayout.clear()
    }

    override fun componentWillUpdate(nextProps: MainListGridProps, nextState: RState) {
        println("MainListGrid::componentWillUpdate")
         this.mainLayout.clear()
    }

    override fun componentDidUpdate(prevProps: MainListGridProps, prevState: RState, snapshot: Any) {
        println("MainListGrid::componentDidUpdate")
        this.mainLayout = createMainLayout(props)
        connectAndDrawLayout()
    }

    private fun connectAndDrawLayout() {
        this.mainLayout.asDynamic().setHtmlElement(document.getElementById(ID))
        this.mainLayout.position = "relative"
        this.mainLayout.draw()
    }

    override fun RBuilder.render() {
        println("MainListGrid::render with $props")
        div {
            // attributesMapOf("id", ID)
            attrs { id = ID }
        }
    }

}

fun createMainLayout(props: MainListGridProps): isc.Layout {
    val mainLayout = isc.HLayout.create()
    val mainBody = createBody(props)
    val grid = createLeftMenu(props)

    mainLayout.setWidth("100%")
    mainLayout.addMembers(arrayOf(grid, mainBody) as Array<Any?>)
    return mainLayout
}

private fun createLeftMenu(props: MainListGridProps): ListGrid {
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
        props.onChangeDataSource(dsName as String)
    }

    return grid
}

private fun createBody(props: MainListGridProps): isc.Layout {
    val boundForm: isc.DynamicForm = isc.DynamicForm.create()
    val boundList: isc.ListGrid = isc.ListGrid.create()
    val boundViewer: isc.DetailViewer = isc.DetailViewer.create()

    val saveBtn: isc.IButton = createButton("Save")
    saveBtn.asDynamic().click = {
        boundForm.saveData({ dsResponse: DSResponse, data: Any, dsRequest: DSRequest ->
            if (dsResponse.status == RPCResponse.STATUS_SUCCESS) {
                // if the save succeeded, clear the UI
                boundForm.clearValues()
                saveBtn.disable()
            }
        })
        true
    }
    val newBtn: isc.IButton = createButton("New")
    val clearBtn: isc.IButton = createButton("Clear")
    val filterBtn: isc.IButton = createButton("Filter")
    val fetchBtn: isc.IButton = createButton("Fetch")

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
        saveBtn.disable()
    }

    val vStack = isc.VStack.create()
    vStack.setWidth("70%")
    vStack.membersMargin = 20

    boundList.setHeight(200)
    boundList.canEdit = true

    boundList.asDynamic().recordClick = { viewer: ListGrid, record: ListGridRecord, recordNum: Number, field: ListGridField, fieldNum: Number, value: Any, rawValue: Any ->
        boundForm.editRecord(record)
        boundViewer.viewSelectedData(boundList)
        saveBtn.enable()
    }

    vStack.addMember(boundList)

    boundForm.numCols = 6
    boundForm.autoFocus = false
    vStack.addMember(boundForm)

    val hLayout = isc.HLayout.create()
    hLayout.membersMargin = 10
    hLayout.setHeight(22)


    hLayout.addMember(saveBtn)

    /* NEW Button */
    newBtn.asDynamic().click = {
        boundForm.editNewRecord()
        saveBtn.enable()
    }
    hLayout.addMember(newBtn)

    /* CLEAR Button */
    clearBtn.asDynamic().click = {
        boundForm.clearValues()
        saveBtn.disable()
    }
    hLayout.addMember(clearBtn)

    /* FILTER Button */
    filterBtn.asDynamic().click = {
        boundList.filterData(boundForm.getValuesAsCriteria(false))
        saveBtn.disable()
    }
    hLayout.addMember(filterBtn)

    /* FETCH Button */
    fetchBtn.asDynamic().click = {
        boundList.fetchData(boundForm.getValuesAsCriteria(false))
        saveBtn.disable()
    }
    hLayout.addMember(fetchBtn)

    vStack.addMember(hLayout)
    vStack.addMember(boundViewer)
    return vStack
}

private fun createButton(title: String): isc.IButton {
    val button = isc.IButton.create()
    button.setTitle(title)
    return button
}

fun RBuilder.mainListGrid(dsName: String?, onChangeDataSource: (String) -> Unit) = child(MainListGrid::class) {
    attrs.dsName = dsName
    attrs.onChangeDataSource = onChangeDataSource
}

