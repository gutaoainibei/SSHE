var centertab;
var tree;
$(function(){
   tree=$("#menutree").tree({
     url:getRequestPath('menuAction!logingetTree.action'),
     //checkbox:true,
     lines:true,
     onClick:function(node){
   	    addTabs(node);
     }//,
   
   });
   centertab=$("#centerTabs").tabs({
   	   //plain:true,
   	   //不显示控制面板的颜色
       fit : true,
       border:false,
       closable : true,
       onContextMenu:function(e,title,index){
           e.preventDefault();
           console.info(title+","+index);
           tabsMenu.menu('show',{
             left : e.pageX,
             top : e.pageY
           }).data('titletab',title);
       }
   });
   tabsMenu=$("#tabMenu").menu({
   onClick : function(item){
       var curtitle=$(this).data('titletab');
   	   var type = $(item.target).attr('type');
   	   if(type=='refresh'){
   	      refreshtabs(curtitle);
   	   }
   	   if(type=='close'){
   	     var t = centertab.tabs('getTab', curtitle);
         if(t.panel('options').closable){
         centertab.tabs('close',curtitle);
         }
          return;
   	   }
   	   var tabsAll=centertab.tabs('tabs');
   	   var closetitle=[];
   	   $.each(tabsAll,function(){
   	     var param=$(this).panel('options');
   	     if(param.closable && param.title!=curtitle && type=='closeother'){
   	         closetitle.push(param.title);
   	     }else if(param.closable && type=='closeall'){
   	        closetitle.push(param.title);
   	     }
   	   });
   	   for(var i=0;i<closetitle.length;i++){
   	         centertab.tabs('close',closetitle[i]);
   	     }
   }
   });
});
function addTabs(node){
	if(centertab.tabs('exists',node.text)){
          centertab.tabs('select',node.text);
     } else{
     	if(node.attributes.url &&node.attributes.url.length>0){
     		if (node.attributes.url.indexOf('!druid.action') < 0) {/*数据源监控页面不需要开启等待提示*/
					$.messager.progress({
						text : '页面加载中....',
						interval : 100
					});
					window.setTimeout(function() {
						try {
							$.messager.progress('close');
						} catch (e) {
						}
					}, 1000);
		  }
          centertab.tabs('add',{    
          title:node.text,
          iconCls:node.iconCls,
          href:getRequestPath(node.attributes.url),
          closable:true,    
          tools:[{    
          iconCls:'icon-mini-refresh',    
          handler:function(){
          	refreshtabs(node.text);
          }    
          }]   
          });
         }else{
            centertab.tabs('add',{
            title:node.text,
            href:'error/unExist.html',
            closable:true
           });
     }
     }
}
function refreshtabs(title){
   var tabs = centertab.tabs('getTab', title);
   tabs.panel('refresh');
}