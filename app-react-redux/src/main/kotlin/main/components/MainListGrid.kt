package main.components

import isc.*
import kotlinx.html.id
import react.*
import react.dom.div
import react.redux.rConnect
import redux.RAction
import redux.WrapperAction
import main.AppState
import kotlin.browser.document

val ID = "main-listgrid"

/** ACTIONS >>> **/
data class MainChangeDataSource(val dsName: String): RAction
/** <<< ACTIONS **/

/** REDUCERS >>> **/
fun mainReducer(state: MainState = MainState(), action: RAction) = when (action) {
    is MainChangeDataSource ->
        state.copy(dsName = action.dsName)

    else -> state
}
/** <<< REDUCERS **/

interface Props: OwnProps, DispatchProps

interface OwnProps : RProps {
    var dsName: String?

    var boundForm: isc.DynamicForm
    var boundList: isc.ListGrid
    var boundViewer: isc.DetailViewer
    var grid: isc.ListGrid
}

interface DispatchProps : RProps {
    /** Function to propagate an action which changes the datasource from the ListGrid **/
    var onChangeDataSource: (String) -> Unit
}

data class MainState(
        // Properties
        override var dsName: String? = null,

        // SmartClient Databound components are properties as well!
        // |- Body components
        override var boundForm: isc.DynamicForm = isc.DynamicForm.create(),
        override var boundList: isc.ListGrid = isc.ListGrid.create(),
        override var boundViewer: isc.DetailViewer = isc.DetailViewer.create(),

        // |- Menu components
        override var grid: isc.ListGrid = isc.ListGrid.create()
) : OwnProps

/**
 * Important: we get in the AppState here (not just the MainState)
 */
private val mapStateToProps: Props.(AppState, Props) -> Unit = { appState, props ->
    val state = appState.mainState
    state
//    dsName = state.dsName
//    boundForm = state.boundForm
//    boundList = state.boundList
//    boundViewer = state.boundViewer
//    grid = state.grid
    
}

private val mapDispatchToProps: DispatchProps.((RAction) -> WrapperAction, Props) -> Unit = { dispatch, props ->
    onChangeDataSource = { ds -> (dispatch.invoke(MainChangeDataSource(ds))) }
}

fun RBuilder.visibleMainListGrid() = child(VisibleMainListGrid::class) {

}

private val c =
        rConnect<AppState, RAction, WrapperAction, Props, Props, DispatchProps, Props>(mapStateToProps, mapDispatchToProps)(MainListGrid::class.js.unsafeCast<RClass<Props>>())

class VisibleMainListGrid(props: Props) : RComponent<Props, RState>(props) {
    override fun RBuilder.render() {
        c {
            attrs.apply { props }
        }
    }
}

/**
 * `Stateless` React Component which renders the listgrid from the SmartGWT builtinds sample project.
 */
class MainListGrid(props: Props) : RComponent<Props, RState>(props) {

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

    override fun componentWillUpdate(nextProps: Props, nextState: RState) {
        println("MainListGrid::componentWillUpdate")
        this.mainLayout.clear()
    }

    override fun componentDidUpdate(prevProps: Props, prevState: RState, snapshot: Any) {
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

fun createMainLayout(props: Props): isc.Layout {
    val mainLayout = isc.HLayout.create()
    val mainBody = createBody(props)
    val grid = createLeftMenu(props)

    mainLayout.setWidth("100%")
    mainLayout.addMembers(arrayOf(grid, mainBody) as Array<Any?>)
    return mainLayout
}

private fun createLeftMenu(props: Props): ListGrid {
    val m = isc.Menu.create()
    m.getOuterElement()

    val grid = props.grid
    grid.setLeft(20)
    grid.setTop(75)
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

private fun createBody(props: Props): isc.Layout {
    val boundForm = props.boundForm
    val boundList = props.boundList
    val boundViewer = props.boundViewer
    val dsName = props.dsName

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

    if (dsName != null) {
        val ds = isc.DataSource.get(dsName)
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
    vStack.setLeft(175)
    vStack.setTop(75)
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

