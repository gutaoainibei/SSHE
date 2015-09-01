<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="user_usermanager_addDialog" class="easyui-dialog" data-options="
	  title:'添加用户',
      modal:true,
      closed:true,
      buttons:[{text : '添加',iconCls : 'icon-add',handler : function(){addRecord();}}]" style="width:500px;height:260px">
   <form id="user_usermanager_addform" method="post">
    <table>
    <tr>
      <th>ID号:</th>
      <td><input name="id" readonly="readonly"></td>
      <th>登录名:</th>
      <td><input name="name"  class="easyui-validatebox" data-options="required:true,missingMessage:'登陆名称必填'" ></td>
    </tr>
      <tr>
      <th>密码:</th>
      <td><input name="pwd" class="easyui-validatebox" data-options="required:true,missingMessage:'登陆名称必填'" ></td>
      <th>创建时间:</th>
      <td><input name="createdatetime" readonly="readonly"></td>
    </tr>
    <tr>
    <th>最后修改时间:</th>
    <td><input name="modifydatetime" readonly="readonly"></td>
    </tr>
    </table>
   </form>
</div>
