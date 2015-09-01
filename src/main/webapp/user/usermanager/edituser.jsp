<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<form id="user_usermanager_editform" method="post">
    <table>
    <tr>
      <th>ID号:</th>
      <td><input name="id" readonly="readonly"></td>
      <th>登录名:</th>
      <td><input name="name"  class="easyui-validatebox" data-options="required:true,missingMessage:'登陆名称必填'" ></td>
    </tr>
      <tr>
      <th>密码:</th>
      <td><input name="pwd" readonly="readonly"></td>
      <th>创建时间:</th>
      <td><input name="createdatetime" class="easyui-datetimebox"></td>
    </tr>
    <tr>
    <th>最后修改时间:</th>
    <td><input name="modifydatetime" class="easyui-datetimebox"></td>
    </tr>
    </table>
</form>
