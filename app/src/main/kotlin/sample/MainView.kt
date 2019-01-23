package sample

import isc.*

class MainView {
    lateinit var presenter: MainPresenter
    
    var layout: isc.Layout

    var boundForm: isc.DynamicForm = isc.DynamicForm.create()
    var boundList: isc.ListGrid = isc.ListGrid.create()
    var boundViewer: isc.DetailViewer = isc.DetailViewer.create()
    var saveBtn: isc.IButton = isc.IButton.create(js("{'title': \"Save\"}") as Any)
    var newBtn: isc.IButton = isc.IButton.create(js("{'title': \"New\"}") as Any)
    var clearBtn: isc.IButton = isc.IButton.create(js("{'title': \"Clear\"}") as Any)
    var filterBtn: isc.IButton = isc.IButton.create(js("{'title': \"Filter\"}") as Any)
    var fetchBtn: isc.IButton = isc.IButton.create(js("{'title': \"Fetch\"}") as Any)


    init {
        layout = createMainLayout()
        // val layout = GlobalGWT.lookup("mainLayout") as isc.Layout
        // val layout = js("globalgwt.GlobalGWT.lookup(\"mainLayout\")")

        register()
    }

    fun dispose() {
        unregister()
    }

    private fun createMainLayout(): isc.Layout {
        val grid = createLeftMenu()
        val mainBody = createBody()

        val mainLayout = isc.HLayout.create()
        mainLayout.setWidth("100%")
        mainLayout.addMembers(arrayOf(grid, mainBody) as Array<Any?>)
        return mainLayout
    }

    private fun createLeftMenu(): ListGrid {
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
                    bindComponents(dsName)
                }

        return grid
    }

    private fun createBody(): isc.Layout {
        val vStack = isc.VStack.create()
        //		vStack.setLeft(175);
        //		vStack.setTop(75);
        vStack.setWidth("70%")
        vStack.membersMargin = 20

        boundList = isc.ListGrid.create()
        boundList.setHeight(200)
        boundList.canEdit = true

        boundList.asDynamic().recordClick =
                { viewer: ListGrid, record: ListGridRecord, recordNum: Number, field: ListGridField, fieldNum: Number, value: Any, rawValue: Any ->
                    boundForm.editRecord(record)
                    saveBtn.enable()
                    boundViewer.viewSelectedData(boundList)
                }

        vStack.addMember(boundList)

        boundForm = isc.DynamicForm.create()
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

        boundViewer = isc.DetailViewer.create()
        vStack.addMember(boundViewer)

        return vStack
        //vStack.draw();
    }

    private fun bindComponents(dsName: String) {
        val ds = isc.DataSource.get(dsName)
        boundList.asDynamic().setDataSource(ds)
        boundViewer.asDynamic().setDataSource(ds)
        boundForm.asDynamic().setDataSource(ds)
        boundList.fetchData()
        newBtn.enable()
        saveBtn.disable()
    }


    private fun register() {
        layout.show()
    }

    private fun unregister() {
        layout.hide()
    }
}
