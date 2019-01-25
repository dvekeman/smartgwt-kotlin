package sample

import isc.*

/**
 * Show the main grid using the store as the source of truth.
 * 
 * For now the view will be fully recreated many times, this will be refactored later.
 */
class MainView(val store: SampleStore) {
    
    var layout: isc.Layout

    init {
        var dsName = store.getState().mainState.dsName
        layout = createMainLayout(store)

        /** while this represents what we conceptually want, it is ugly for now (clear() and draw()) */
        store.subscribe {
            val newDsName = store.getState().mainState.dsName
            println("Old $dsName vs new $newDsName")
            if(dsName != newDsName){
                dsName = newDsName
                layout.clear()
                layout = createMainLayout(store)
                register()
            }
        }
        
        /** Keeping here for reference in case we want to access legacy layouts **/
        // val layout = GlobalGWT.lookup("mainLayout") as isc.Layout
        // val layout = js("globalgwt.GlobalGWT.lookup(\"mainLayout\")")

        register()
    }

    private fun register() {
        layout.draw()
    }

    fun dispose() {
        layout.clear()
    }

}

fun createMainLayout(store: SampleStore): isc.Layout {
    val mainLayout = isc.HLayout.create()

    val dsName = store.getState().mainState.dsName
    val mainBody = createBody(dsName)
    val grid = createLeftMenu(store)

    mainLayout.setWidth("100%")
    mainLayout.addMembers(arrayOf(grid, mainBody) as Array<Any?>)
    return mainLayout
}

fun createLeftMenu(store: SampleStore): ListGrid {
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
                store.dispatch(MainChangeDataSource(dsName))
            }

    return grid
}

fun createBody(dsName: String?): isc.Layout {
    val saveBtn: isc.IButton = isc.IButton.create(js("{'title': \"Save\"}") as Any)
    val newBtn: isc.IButton = isc.IButton.create(js("{'title': \"New\"}") as Any)
    val clearBtn: isc.IButton = isc.IButton.create(js("{'title': \"Clear\"}") as Any)
    val filterBtn: isc.IButton = isc.IButton.create(js("{'title': \"Filter\"}") as Any)
    val fetchBtn: isc.IButton = isc.IButton.create(js("{'title': \"Fetch\"}") as Any)
    val boundForm: isc.DynamicForm = isc.DynamicForm.create()
    val boundList: isc.ListGrid = isc.ListGrid.create()
    val boundViewer: isc.DetailViewer = isc.DetailViewer.create()

    println("createBody:: create body for $dsName...")
    if(dsName != null){
        newBtn.enable()
        saveBtn.disable()

        val ds = isc.DataSource.get(dsName)
        ds?.useHttpProxy = true
        if(ds?.requestProperties != null){
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

    val vStack = isc.VStack.create()
    //		vStack.setLeft(175);
    //		vStack.setTop(75);
    vStack.setWidth("70%")
    vStack.membersMargin = 20

    boundList.setHeight(200)
    boundList.canEdit = true

    boundList.asDynamic().recordClick =
            { viewer: ListGrid, record: ListGridRecord, recordNum: Number, field: ListGridField, fieldNum: Number, value: Any, rawValue: Any ->
                boundForm.editRecord(record)
                saveBtn.enable()
                boundViewer.viewSelectedData(boundList)
            }

    vStack.addMember(boundList)

    boundForm.numCols = 6
    boundForm.autoFocus = false
    vStack.addMember(boundForm)

    val hLayout = isc.HLayout.create(js(
            "{'membersMargin': 10 }"
    ) as? Any)
    hLayout.setHeight(22)

    saveBtn.asDynamic().click =
            {
                boundForm.saveData(
                        { dsResponse: DSResponse, data: Any, dsRequest: DSRequest ->
                            if (dsResponse.status == RPCResponse.STATUS_SUCCESS) {
                                // if the save succeeded, clear the UI
                                boundForm.clearValues()
                                saveBtn.disable()
                            }
                        }
                )
                true
            }

    hLayout.addMember(saveBtn)

    newBtn.asDynamic().click =
            {
                boundForm.editNewRecord()
                saveBtn.enable()
            }
    hLayout.addMember(newBtn)

    clearBtn.asDynamic().click =
            {
                boundForm.clearValues()
                saveBtn.disable()
            }
    hLayout.addMember(clearBtn)

    filterBtn.asDynamic().click =
            {
                boundList.filterData(boundForm.getValuesAsCriteria(false))
                saveBtn.disable()
            }
    hLayout.addMember(filterBtn)

    fetchBtn.asDynamic().click =
            {
                boundList.fetchData(boundForm.getValuesAsCriteria(false))
                saveBtn.disable()
            }
    hLayout.addMember(fetchBtn)

    vStack.addMember(hLayout)

    vStack.addMember(boundViewer)

    return vStack
    //vStack.draw();
}