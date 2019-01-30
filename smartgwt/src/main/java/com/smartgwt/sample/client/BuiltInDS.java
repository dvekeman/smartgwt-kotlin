package com.smartgwt.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.rpc.RPCManager;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.SortArrow;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.viewer.DetailViewer;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class BuiltInDS implements EntryPoint {
	private ListGrid boundList;
	private DynamicForm boundForm;
	private IButton saveBtn;
	private DetailViewer boundViewer;
	private IButton newBtn;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		RPCManager.setAllowCrossDomainCalls(true);
		
		Layout mainLayout = initializeLayout();
		mainLayout.draw();
		GlobalGWT.register("mainLayout", mainLayout.getOrCreateJsObj());

		// GlobalGWT.startApp();
	}

//	private void registerDebugKey() {
//		KeyIdentifier debugKey = new KeyIdentifier();
//		debugKey.setCtrlKey(true);
//		debugKey.setKeyName("D");
//		Page.registerKey(debugKey, new PageKeyHandler() {
//			public void execute(String keyName) {
//				SC.showConsole();
//			}
//		});
//	}

	private Layout initializeLayout() {
		ListGrid grid = createLeftMenu();
		Layout mainBody = createBody();
		Layout mainLayout = new HLayout();
		mainLayout.setWidth100();
		mainLayout.addMembers(grid, mainBody);
		return mainLayout;
	}

	private ListGrid createLeftMenu() {
		Menu m = new Menu();
		m.getOuterElement();
		
		ListGrid grid = new ListGrid();
		grid.setWidth(130);
		grid.setHeight100();
		grid.setLeaveScrollbarGap(false);
		grid.setShowSortArrow(SortArrow.NONE);
		grid.setCanSort(false);
		grid.setFields(new ListGridField("dsTitle", "Select a DataSource"));
		grid.setData(new ListGridRecord[]{
				new DSRecord("Animals", "animals"),
				new DSRecord("Office Supplies", "supplyItem"),
				new DSRecord("Employees", "employees")}
		);
		grid.setSelectionType(SelectionStyle.SINGLE);
		grid.addRecordClickHandler(new RecordClickHandler() {
			public void onRecordClick(RecordClickEvent event) {
				DSRecord record = (DSRecord) event.getRecord();
				bindComponents(record.getDsName());
			}
		});
		return grid;
	}

	private Layout createBody() {
		VStack vStack = new VStack();
		vStack.setWidth("70%");
		vStack.setMembersMargin(20);

		boundList = new ListGrid();
		boundList.setHeight(200);
		boundList.setCanEdit(true);

		boundList.addRecordClickHandler(new RecordClickHandler() {
			public void onRecordClick(RecordClickEvent event) {
				Record record = event.getRecord();
				boundForm.editRecord(record);
				saveBtn.enable();
				boundViewer.viewSelectedData(boundList);
			}
		});
		vStack.addMember(boundList);

		boundForm = new DynamicForm();
		boundForm.setNumCols(6);
		boundForm.setAutoFocus(false);
		vStack.addMember(boundForm);

		HLayout hLayout = new HLayout(10);
		hLayout.setMembersMargin(10);
		hLayout.setHeight(22);

		saveBtn = new IButton("Save");
		saveBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				boundForm.saveData(new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() == DSResponse.STATUS_SUCCESS) {
							// if the save succeeded, clear the UI
							boundForm.clearValues();
							saveBtn.disable();
						}
					}
				});
			}
		});
		hLayout.addMember(saveBtn);

		newBtn = new IButton("New");
		newBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				boundForm.editNewRecord();
				saveBtn.enable();
			}
		});
		hLayout.addMember(newBtn);

		IButton clearBtn = new IButton("Clear");
		clearBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				boundForm.clearValues();
				saveBtn.disable();
			}
		});
		hLayout.addMember(clearBtn);

		IButton filterBtn = new IButton("Filter");
		filterBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				boundList.filterData(boundForm.getValuesAsCriteria());
				saveBtn.disable();
			}
		});
		hLayout.addMember(filterBtn);

		IButton fetchBtn = new IButton("Fetch");
		fetchBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				boundList.fetchData(boundForm.getValuesAsCriteria());
				saveBtn.disable();
			}
		});
		hLayout.addMember(fetchBtn);

		vStack.addMember(hLayout);

		boundViewer = new DetailViewer();
		vStack.addMember(boundViewer);

		return vStack;
	}

	private void bindComponents(String dsName) {
		DataSource ds = DataSource.get(dsName);
		boundList.setDataSource(ds);
		boundViewer.setDataSource(ds);
		boundForm.setDataSource(ds);
		boundList.fetchData();
		newBtn.enable();
		saveBtn.disable();
	}
}
