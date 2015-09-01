function showsessionInfo(){
   $("#sessiondialog").dialog('open');
}
function exituser(sign){
   $("#sessionInfoDiv").html('');
   $.post(getRequestPath('userAction!exituser.action'),function(){
      if(sign){
         location.replace(getRequestPath(''));
      }else{
        $("#index_logDialog").dialog('open');
      }
   });
}