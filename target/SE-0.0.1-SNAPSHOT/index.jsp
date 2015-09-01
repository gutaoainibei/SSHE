<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>SSHE框架测试</title>
	<script type="text/javascript" src="<%=basePath %>jslib/jquery-easyui-1.4.2/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>jslib/jquery-easyui-1.4.2/jquery.cookie.js" charset="utf-8"></script>
	<script type="text/javascript" src="<%=basePath %>jslib/jquery-easyui-1.4.2/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>jslib/jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js"></script>
	<link id="easyuiTheme" rel="stylesheet" type="text/css" href="<%=basePath %>jslib/jquery-easyui-1.4.2/themes/<c:out value="${cookie.easyuiThemeName.value}" default="default"/>/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>jslib/jquery-easyui-1.4.2/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/center.css">

	<script type="text/javascript" src="<%=basePath %>ejs/exten.js"></script>
	<script type="text/javascript" src="<%=basePath %>myJs/menutree.js"></script>
	 <script type="text/javascript">
	    var basePath = "<%=basePath %>";
	    function getRequestPath(path){
	    
		   return basePath+path;
	   }
     </script>
  </head>
  <body class="easyui-layout">
    <div data-options="region:'north'" style="height:60px;" class="logo">
      <jsp:include page="indexLayout/north.jsp"></jsp:include>
    </div>   
    <div data-options="region:'south',href:'indexLayout/south.jsp'" style="height:40px;"></div>   
    <div data-options="region:'east',href:'indexLayout/east.jsp',iconCls:'icon-reload',title:'当前状态',split:true" style="width:200px;">   
    </div>   
    <div data-options="region:'west'" style="width:200px;">
        <jsp:include page="indexLayout/west.jsp"></jsp:include>
   </div>   
    <div data-options="region:'center',title:'tabs' ">
        <jsp:include page="indexLayout/center.jsp"></jsp:include>
    </div>  
    <jsp:include page="user/login.jsp"></jsp:include>
    <jsp:include page="user/reg.jsp"></jsp:include>
  </body>
</html>
