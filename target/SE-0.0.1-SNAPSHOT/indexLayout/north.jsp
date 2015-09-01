<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
<script type="text/javascript" src="myJs/north_sessionIfo.js"></script>
<div id="sessionInfoDiv" style="position: absolute; right: 5px; top: 10px; ">
    <c:if test="${sessionInfo.id != null}">[<strong>${sessionInfo.name}</strong>],欢迎你登录[<strong>${sessionInfo.ip}</strong>]IP登录</c:if>
</div>
<div style="position: absolute; right: 0px; bottom: 0px; ">
	<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#indexlayout_north_skinMenu',iconCls:'icon-large-picture'">更换皮肤</a>
    <a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#indexlayout_north_themeMenu',iconCls:'icon-tip'">控制面板</a>
    <a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#indexlayout_north_exitMenu',iconCls:'icon-clear'">注销</a>
</div>
<div id="indexlayout_north_skinMenu" style="width: 120px; display: none;">
	<div onclick="changeTheme('default');" data-options="iconCls:'icon-large-clipart'">默认主题</div>
	<div onclick="changeTheme('gray');" data-options="iconCls:'icon-large-clipart'">灰色主题</div>
	<div onclick="changeTheme('metro');" data-options="iconCls:'icon-large-clipart'">白色主题</div>
	<div onclick="changeTheme('ui-sunny');" data-options="iconCls:'icon-large-clipart'">阳光主题</div>
	<div onclick="changeTheme('black');" data-options="iconCls:'icon-large-clipart'">黑色主题</div>
	<div onclick="changeTheme('metro-green');" data-options="iconCls:'icon-large-clipart'">白绿主题</div>
	<div onclick="changeTheme('metro-orange');" data-options="iconCls:'icon-large-clipart'">白橙主题</div>
</div>
<div id="indexlayout_north_themeMenu" style="width: 120px; display: none;">
	<div onclick="showsessionInfo();" data-options="iconCls:'icon-man'">个人信息</div>
	<div class="menu-sep"></div>
	<div>
	  <span>更换主题</span>
	  <div>
	  <div onclick="changeTheme('default');">默认主题</div>
	  <div onclick="changeTheme('gray');">灰色主题</div>
	  <div onclick="changeTheme('metro');">白色主题</div>
	  <div onclick="changeTheme('ui-sunny');">阳光主题</div>
	  <div onclick="changeTheme('black');">黑色主题</div>
	  <div onclick="changeTheme('metro-green');">白绿主题</div>
	  <div onclick="changeTheme('metro-orange');">白橙主题</div>
	  </div>
	</div>
</div>

<div id="indexlayout_north_exitMenu" style="width: 120px; display: none;">
   <div onclick="$('#index_logDialog').dialog('open');" data-options="iconCls:'icon-lock'">锁定用户</div>
   <div class="menu-sep"></div>
   <div onclick="exituser(true);" data-options="iconCls:'icon-back'">退出系统</div>
   <div onclick="exituser();" data-options="iconCls:'icon-reload'">重新登录</div>
</div>

<div id="sessiondialog" class="easyui-dialog" data-options="title:'编辑框',width: 500,height: 300,closed: true,modal: true,buttons:[{text:'修改密码',iconCls:'icon-edit',handler:function(){alert('123')}}]">
<div id="sessionlayout" class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'west',split:true" style="width:250px">
     <div id="sessionPanel" class="easyui-panel" data-options="title:'个人信息',fit : true,border : false">
         <form>
           <table>
              <tr><th>登录名:</th><td><input type="text" readonly="readonly" value="${sessionInfo.name}"></td></tr>
              <tr><th>登录IP:</th><td><input type="text" readonly="readonly" value="${sessionInfo.ip}"></td></tr>
              <tr><th>修改密码:</th><td><input type="text" value=""></td></tr>
              <tr><th>所属角色:</th><td><textarea rows="4" cols="15"></textarea></tr>
           </table>
         </form>
     </div>
    </div>
    <div data-options="region:'center',title:'权限管理'">
     ttianshang 
    </div>
  </div>
</div>
</body>
