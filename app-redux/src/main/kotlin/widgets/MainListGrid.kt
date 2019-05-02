package widgets

import isc.DSRequest
import isc.DSResponse
import isc.RPCResponse
import main.SampleStore

class MainListGrid(val store: SampleStore) {

    private lateinit var mainLayout: isc.Layout

    private val grid = isc.ListGrid.create(js(
            """
{ left: 20
, top: 75
, width: 130
, height: "100%"
, leaveScrollbarGap: false
, showSortArrow: "none"
, canSort: false
, selectionType: "single"
, fields: [{ name: "dsTitle", title: "Select a DataSource"}]
, data:
    [ { dsTitle: "Animals"
      , dsName: "animals"
      }
    , { dsTitle: "Office Supplies"
      , dsName: "supplyItem"
      }
    , { dsTitle: "Employees"
      , dsName: "employees"
      }
    ]
}
"""), null)

    private val boundForm = isc.DynamicForm.create(js("""
{ numCols: 6
, autoFocus: false
}
    """), null)

    private val boundList = isc.ListGrid.create(js("""
{ height: 200
, canEdit: true
}
    """), null)

    private val boundViewer = isc.DetailViewer.create(null, null)

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

        mainLayout = isc.HLayout.create(null, null)
        mainLayout.setWidth("100%")
        mainLayout.addMembers(arrayOf(grid, mainBody), position = null)
        return mainLayout
    }

    private fun createLeftMenu(): isc.ListGrid {
        val m = isc.Menu.create(null, null)
        m.getOuterElement()

        val grid = grid

        grid.asDynamic().recordClick = { viewer: isc.ListGrid, record: isc.ListGridRecord, recordNum: Number, field: isc.ListGridField, fieldNum: Number, value: Any, rawValue: Any ->
            val dsName = record.asDynamic().dsName
            bindComponents(dsName as String)
        }

        return grid
    }

    private fun createBody(): isc.Layout {
        saveBtn.asDynamic().click = {
            boundForm.saveData(callback = { dsResponse: DSResponse, data, dsRequest: DSRequest ->
                if (dsResponse.status == RPCResponse.STATUS_SUCCESS) {
                    // if the save succeeded, clear the UI
                    boundForm.clearValues()
                    saveBtn.disable()
                }
            }, requestProperties = null)
            true
        }

        val vStack = isc.VStack.create(js("""
{ left: 175
, top: 75
, width: "70%"
, membersMargin: 20
}
        """), null)

        boundList.asDynamic().recordClick = { viewer: isc.ListGrid, record: isc.ListGridRecord, recordNum: Number, field: isc.ListGridField, fieldNum: Number, value: Any, rawValue: Any ->
            boundForm.editRecord(record)
            boundViewer.viewSelectedData(boundList)
            saveBtn.enable()
        }

        vStack.addMember(boundList, position = null)
        vStack.addMember(boundForm, position = null)

        val hLayout = isc.HLayout.create(js("""
{ membersMargin: 10
, height: 22
}
        """), null)
        hLayout.addMember(saveBtn, position = null)

        /* NEW Button */
        newBtn.asDynamic().click = {
            boundForm.editNewRecord(initialValues = {})
            saveBtn.enable()
        }
        hLayout.addMember(newBtn, position = null)

        /* CLEAR Button */
        clearBtn.asDynamic().click = {
            boundForm.clearValues()
            saveBtn.disable()
        }
        hLayout.addMember(clearBtn, position = null)

        /* FILTER Button */
        filterBtn.asDynamic().click = {
            boundList.filterData(
                    boundForm.getValuesAsCriteria(false, textMatchStyle = null),
                    callback = { response, data, request -> null },
                    requestProperties = null
            )
            saveBtn.disable()
        }
        hLayout.addMember(filterBtn, position = null)

        /* FETCH Button */
        fetchBtn.asDynamic().click = {
            boundList.fetchData(
                    criteria = boundForm.getValuesAsCriteria(false, textMatchStyle = null),
                    callback = { response, data, request ->
                        println("Received ")
                        null
                    },
                    requestProperties = null
            )
            saveBtn.disable()
        }
        hLayout.addMember(fetchBtn, position = null)

        vStack.addMember(hLayout, position = null)
        vStack.addMember(boundViewer, position = null)
        return vStack
    }

    private fun bindComponents(dsName: String) {
        val ds = isc.DataSource.get(dsName)

        println("render:: DataSource: ${ds.asDynamic()}")

        boundList.setDataSource(ds, fields = null)//asDynamic().setDataSource(ds)
        boundViewer.setDataSource(ds, fields = null)//asDynamic().setDataSource(ds)
        boundForm.setDataSource(ds, fields = null)//asDynamic().setDataSource(ds)
        boundList.fetchData(
                criteria = {},
                callback = { response, data, request ->
                    println("bindComponents: Received callback from boundList.fetchData")
                    null
                },
                requestProperties = null
        )

        newBtn.enable()
        saveBtn.disable()
    }

}


