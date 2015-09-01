<%@ page language="java" pageEncoding="UTF-8"%>
<body>
<script type="text/javascript" src="myJs/usermanager.js"></script>
<div id="cc" class="easyui-layout" data-options="fit:true">   
    <div data-options="region:'north',title:'过滤条件'" style="height:119px;">
    <form id="user_usermanager_searchForm">
			<table class="tableForm datagrid-toolbar" style="width: 100%;height: 100%;">
				<tr>
					<th>用户名</th>
					<td><input name="name" style="width:318px;" /></td>
				</tr>
				<tr>
					<th>创建时间</th>
					<td><input name="createdatetimeStart" class="easyui-datetimebox" data-options="editable:false" style="width: 155px;" />至<input name="createdatetimeEnd" class="easyui-datetimebox" data-options="editable:false" style="width: 155px;" /></td>
				</tr>
				<tr>
					<th>最后修改时间</th>
					<td><input name="modifydatetimeStart" class="easyui-datetimebox" data-options="editable:false" style="width: 155px;" />至<input name="modifydatetimeEnd" class="easyui-datetimebox" data-options="editable:false" style="width: 155px;" />
					<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchForm();">过滤</a>
					<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cut'" onclick="cleanSearch();">取消</a></td>
				</tr>
			</table>
		</form>
    </div>   
    <div data-options="region:'center',title:'表单操作'">
    <table id="userdatagrid"></table>
    </div>   
</div>  
<jsp:include page="usermanager/adduser.jsp"></jsp:include>
<div id="mm" class="easyui-menu" style="width:120px;display:none">        
    <div data-options="iconCls:'icon-add'" onclick="addRow()">添加</div>   
    <div data-options="iconCls:'icon-edit'" onclick="editRowdata()">修改</div> 
    <div data-options="iconCls:'icon-remove'" onclick="deleteRecord()">删除</div> 
</div>  
</body>
