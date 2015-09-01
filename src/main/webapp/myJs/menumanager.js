var menutreegrid;
$(function(){
     menutreegrid=$("#treedatagrid").treegrid({
  	 title:'菜单管理',
     url:getRequestPath('menuAction!getTreeDatagrid.action'),
     idField:'id',
     parentField:'pid',
     fit:true,
     treeField:'text',
     columns:[[{
        title:'ID号',
        field:'id',
        width:'100',
        hidden:true
     },{
        title:'文本',
        field:'text',
        width:'150'
     },{
     	title:'图标',
        field:'iconCls',
        width:'100'
     },{
     	title:'路径',
        field:'url',
        width:'100'
     }]],
     toolbar:[{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        
        }
     },'-',{
        text:'删除',
        iconCls:'icon-remove',
        handler:function(){
        
        }
     },'-',{
        text:'添加',
        iconCls:'icon-add',
        handler : function(){
        
        }
     },'-',{
        text:'取消编辑',
        iconCls:'icon-clear',
        handler : function(){
          menutreegrid.treegrid();
        }
     },'-',{
        text:'展开',
        iconCls:'icon-redo',
        handler : function(){
           menutreegrid.treegrid('expandAll');
        }
     },'-',{
        text:'折叠',
        iconCls:'icon-undo',
        handler : function(){
           menutreegrid.treegrid('collapseAll');
        }
     }]
  });
});