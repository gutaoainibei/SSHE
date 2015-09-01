$(function(){
  $("#reg_regForm input").bind('keyup',function(event){
    if(event.keyCode=='13'){
    	reg();
    }
  });
  
});
function reg(){
	   if($("#reg_regForm").form("validate")){
		   $.ajax({
		   	      type:"POST",
				  url : getRequestPath('userAction!save.action'),
				  data : $("#reg_regForm").serialize(),
				  async : true,
				  dataType : 'json',
				  success : function(data){
					  if(data.success==true){
						 $("#index_regDialog").dialog("close");
				      }
					  $.messager.show({title:'提示',msg:data.msg});
				   }	 
			      });	
	   }else{
		   alert("表单验证失败！");
	   }
	
}


  