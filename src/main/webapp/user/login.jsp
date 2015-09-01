<%@ page language="java" pageEncoding="UTF-8"%>
<body>
<script type="text/javascript" src="myJs/index_dialog.js"></script>
<script type="text/javascript">
var sessionInfo;
$(function(){
	sessionInfo={
			    id : "${sessionInfo.id}",
			    name : "${sessionInfo.name}",
			    ip : "${sessionInfo.ip}"
	};
	if(sessionInfo.id){
		console.info(sessionInfo.id);
		window.setTimeout(function(){
		$("div.validatebox-tip").remove();
		},500);
		$("#index_logDialog").dialog("close");
		flashOnlineDatagrid();
		}
});
</script>
<div id="index_logDialog">
    <form id="login_loginForm" method="post">
		<table>
			<tr>
				<th>登录名</th>
				<td><input name="name" class="easyui-validatebox" data-options="required:true,missingMessage:'登陆名称必填'" />
				</td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input type="password" name="pwd" class="easyui-validatebox" data-options="required:true,missingMessage:'密码必填'" />
				</td>
			</tr>
		</table>
	</form>
    </div>
</body>