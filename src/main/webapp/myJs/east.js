var mycalendar;
var onlineDatagrid;
var onlinePanel;
$(function(){
  mycalendar=$("#mycalendar").calendar({
    fit : true,
    border : false,
    current:new Date(),
    onSelect:function(data){
      mycalendar.calendar('moveTo', new Date());
    }
  });
  
  onlinePanel=$("#onlinePanel").panel({
         //iconCls:'icon-reload',
  	     tools:[{
  	     iconCls : 'icon-reload',
  	     handler:function(){
  	         if(onlineDatagrid.datagrid('options').url){
  	            onlineDatagrid.datagrid('load');
  	         }
  	     }}]
  });
  
  onlineDatagrid=$("#onlineDatagrid").datagrid({
            title : '',
			iconCls : '',
			fit : true,
			fitColumns : true,
			pagination : false,
			pageSize : 10,
			pageList : [ 10 ],
			nowarp : false,
			border : false,
			idField : 'id',
			sortName : 'name',
			sortOrder : 'desc',
			frozenColumns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				hidden : true
			} ] ],
			columns : [ [ {
				title : '登录名',
				field : 'name',
				width : 150,
				sortable : true,
				formatter:function(value,row,index){
				  return '<span title="'+'登录名是:'+value+'">'+value+'</span>';
				}
			}, {
				title : 'IP',
				field : 'ip',
				width : 150,
				sortable : true,
				formatter:function(value,row,index){
				  return '<span title="'+'IP是:'+value+'">'+value+'</span>'; 
				}
			}, {
				title : '登录时间',
				field : 'datatime',
				width : 150,
				sortable : true,
				formatter:function(value,row,index){
				  return '<span title="'+'登录时间是:'+value+'">'+value+'</span>';
				}
			} ] ],
			
//			onClickRow : function(rowIndex, rowData) {
//				userOnlineInfoDataGrid.datagrid('loadData', [ {
//					value : '登录名',
//					name : rowData.cname
//				}, {
//					value : 'IP',
//					name : rowData.cip
//				}, {
//					value : '登录时间',
//					name : rowData.cdatetime
//				} ]);
//				userOnlineInfoDialog.dialog('open');
//				$(this).datagrid('unselectAll');
//			},
			  onLoadSuccess : function(data) {
			  onlinePanel.panel('setTitle', '( ' + data.total + ' )人在线');
			}
  });
  
});