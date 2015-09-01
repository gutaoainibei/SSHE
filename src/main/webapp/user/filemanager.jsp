<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
   <s:form action="updata" namespace="/" method="POST" enctype="multipart/form-data">
   <s:textfield name="title" label="文件标题"/>
   <s:file name="upload" label="选择文件"/>
   <s:submit value="上传" align="left"></s:submit> 
   </s:form>
  </body>
</html>
