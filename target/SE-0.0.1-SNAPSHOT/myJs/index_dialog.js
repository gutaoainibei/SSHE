$(function(){
  $("#login_loginForm input").bind('keyup',function(event){
    if(event.keyCode=='13'){
    	login();
    }
  });
  window.setTimeout(function(){
    $("#login_loginForm input[name=name]").focus();
  },0);
  $("#index_logDialog").dialog({
       title:'登录',
       modal:true,
       closable:false,
       buttons:[{
				text:'注册',
				iconCls:'icon-edit',
				handler:function(){
					$('#reg_regForm input').val('');
					$('#index_regDialog').dialog('open');
				}
			},{
				text:'登录',
				iconCls:'icon-help',
				handler:function(){
					login();
	}}]
  });
});
function login(){
   if($("#login_loginForm").form("validate")){
		     $.ajax({
		   	       type:"POST",
				   url : getRequestPath('userAction!login.action'),
				   data : $("#login_loginForm").serialize(),
				   async : true,
				   dataType : 'json',
				   success : function(data){
				   if(data.success==true){
				   	     //console.info("dialog");
						$("#index_logDialog").dialog('close');
						$('#sessionInfoDiv').html(fs('[<strong>{0}</strong>],欢迎你!您使用[<strong>{1}</strong>]IP登录!',data.obj.name,data.obj.ip));
						flashOnlineDatagrid();
				   }
				   $.messager.show({title:'提示',msg:data.msg});
				   }	 
			   });	
	   }else{
		   alert("表单验证失败！");
	   }
}
function flashOnlineDatagrid(){
            window.setTimeout(function() {
			if ($('#onlineDatagrid').length > 0) {
			onlineDatagrid.datagrid({
			pagination : true,
			url : getRequestPath('onlineAction!loginOnlineDatagrid.action')
			});
			var p=onlineDatagrid.datagrid('getPager');
			p.pagination({
				  showPageList : false,
				  showRefresh : false,
				  beforePageText : '',
				  afterPageText : '/{pages}',
				  displayMsg : ''
				});
				console.info("正确");
			  }
		    }, 2000);
}