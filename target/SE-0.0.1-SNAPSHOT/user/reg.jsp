<%@ page language="java" pageEncoding="UTF-8"%>
<body>
<script type="text/javascript" src="myJs/regDialog.js"></script>
<div id="index_regDialog" class="easyui-dialog" 
data-options="title:'注册',modal:true,closed:true,
buttons:[{text:'注册',iconCls:'icon-edit',handler:function(){reg();}}]" 
style="width:250px">
    <form id="reg_regForm" method="post">
		<table>
			<tr>
				<th>登录名</th>
				<td><input name="name" class="easyui-validatebox" data-options="required:true,missingMessage:'登陆名称必填'" />
				</td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input type="password" name="pwd" class="easyui-validatebox" data-options="required:true" />
				</td>
			</tr>
			<tr>
				<th>重复密码</th>
				<td><input type="password" name="repwd" class="easyui-validatebox" data-options="required:true,validType:'eqPwd[\'#reg_regForm input[name=pwd]\']'" />
				</td>
			</tr>
		</table>
	</form>
</div>
</body>