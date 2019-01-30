package main

import isc.*

class MainListGrid(val store: SampleStore) {

    private lateinit var mainLayout: isc.Layout
    private val grid = isc.ListGrid.create()
    private val boundForm = isc.DynamicForm.create()
    private val boundList = isc.ListGrid.create()
    private val boundViewer = isc.DetailViewer.create()

    private val newBtn = createStandardButton("New")
    private val saveBtn = createStandardButton("Save")
    private val clearBtn: isc.Button = createStandardButton("Clear")
    private val filterBtn: isc.Button = createStandardButton("Filter")
    private val fetchBtn: isc.Button = createStandardButton("Fetch")

    fun getCanvas(): isc.Canvas {
        return createMainLayout()
    }

    fun createMainLayout(): isc.Layout {
        val mainBody = createBody()
        val grid = createLeftMenu()

        mainLayout = isc.HLayout.create()
        mainLayout.setWidth("100%")
        mainLayout.addMembers(arrayOf(grid, mainBody))
        return mainLayout
    }

    private fun createLeftMenu(): ListGrid {
        val m = isc.Menu.create()
        m.getOuterElement()

        val grid = grid
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
            bindComponents(dsName as String)
        }

        return grid
    }

    private fun createBody(): isc.Layout {
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

    private fun bindComponents(dsName: String) {
        val ds = isc.DataSource.get(dsName)
        ds?.useHttpProxy = true
        if (ds?.requestProperties != null) {
            val requestProperties = ds.requestProperties
            val requestHeaders = requestProperties.httpHeaders
            requestHeaders.asDynamic()["Origin"] = "$scheme://$host:$port" // CORS Header for POC
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

}


