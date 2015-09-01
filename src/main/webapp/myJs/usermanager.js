var userdatagrid;
var adddialog;
var editRow=undefined;
$(function(){
       userdatagrid=$("#userdatagrid").datagrid({
       title:'用户管理',
       url:getRequestPath('userAction!datagrid.action'),
       fit:true,
       fitColumns:true,
       sortName:'name',
       sortOrder:'asc',
       pagination:true,
       pageSize:5,
       pageList:[5,10,15,20,25,30],
       idField:'id',
       striped:true,
       frozenColumns:[[
       	{
         title:'全选',
       	 field:'rownumbers',
       	 checkbox:true
       	 },{
         title:'ID',
       	 field:'id',
       	 hidden:true
       	 },{
       	  title:'用户名',
          field:'name',
          width:'150',
          sortable:true,
          editor:{//编辑效果这个效果是为了对行进行编辑时必须加的
	   	  type:'validatebox',//编辑类型
		  options:{//其他属性
			required:true//必须要填
		  }}
       	 }]],
       columns:[[{
       	 title:'密码',
       	 field:'pwd',
       	 width:'150',
       	 formatter:function(value,row,index){
       	   return '******';
       	 }
       },{
       	 title:'创建时间',
       	 field:'createdatetime',
       	 width:150,
       	 sortable:true,
       	 formatter:function(value,row,index){
       	   return '<span title="'+value+'">'+value+'</span>';
       	 }
       },{
       	title:'最后修改时间',
       	field:'modifydatetime',
       	width:150,
       	sortable:true
       }]],
       toolbar:[{
       	 text:'编辑',
       	 iconCls:'icon-edit',
       	 handler:function(){
       	 	editRecord();
       	 }
       },'-',{
       	 text:'删除',
       	 iconCls:'icon-remove',
       	 handler:function(){
       	       deleteRecord();
       	 }
       },'-',{
       	  text:'添加',
       	  iconCls:'icon-add',
       	  handler:function(){
       	  	$('#user_usermanager_addform input').val('');
       	    $("#user_usermanager_addDialog").dialog('open');
       	  }
       },'-',{
          text:'保存',
          iconCls:'icon-save',
          handler:function(){
          	if(editRow!=undefined){
            userdatagrid.datagrid('endEdit',editRow);
          	}
          }
         },'-',{
         text:'取消编辑',
         iconCls:'icon-redo',
         handler:function(){
           editRow=undefined;
           userdatagrid.datagrid('rejectChanges');
           userdatagrid.datagrid('unselectAll');
//           userdatagrid.datagrid('clearSelections');
         }
       }],
       onDblClickRow:function(rowIndex, rowData){
       	 if(editRow!=undefined){
       	   userdatagrid.datagrid('endEdit',rowIndex);
       	 }
       	 if(editRow==undefined){
       	 changeEditorEditRow();
         userdatagrid.datagrid('beginEdit',rowIndex);
         editRow=rowIndex;
         }
       },
       onRowContextMenu : function(e, rowIndex, rowData){
       	//rowIndex是当前所在行的索引
          e.preventDefault();//防止捕捉浏览器的右击事件
          $(this).datagrid('clearSelections');
          editRow=undefined;
          $(this).datagrid('selectRow',rowIndex);
          //editRow=rowIndex;
          $("#mm").menu('show',{
             left: e.pageX,//在鼠标点击处显示菜单
             top: e.pageY
          });
          
       },
       onAfterEdit : function(rowIndex, rowData, changes){
           var inserted=userdatagrid.datagrid('getChanges','inserted');
           var updated=userdatagrid.datagrid('getChanges','updated');
           if (inserted.length < 1 && updated.length < 1) {
					editRow = undefined;
					userdatagrid.datagrid('unselectAll');
					return;
		   }
           var url='';
           if(inserted.length>0){
           	url='userAction!save.action';
           	console.info(url);
           }
           if(updated.length>0){
             url='userAction!edit.action';
             console.info(url);
           }
           $.ajax({
              type : 'POST',
              url : getRequestPath(url),
              data : rowData,
              async : true,
              dataType : 'json',
              success : function(data){
                 if(data.success){
                  //userdatagrid.datagrid('acceptChanges');
                  userdatagrid.datagrid('updateRow',{
	              index: userdatagrid.datagrid('getRowIndex',data.obj.id),
	              row: data.obj
                  });
                  $.messager.show({title:'成功',msg:data.msg});
                  editRow=undefined;
                 }else{
                   userdatagrid.datagrid('beginEdit',editRow);
                   $.messager.show({title:'失败',msg:data.msg});
                 }
                 userdatagrid.datagrid('clearSelections');
              }
           });
       }
  });
});
function  searchForm(){
	var data=serializeObject($("#user_usermanager_searchForm"));
    userdatagrid.datagrid('load',data);
}
function cleanSearch(){
	userdatagrid.datagrid('load',{});
    $("#user_usermanager_searchForm input").val('');
    
}
function addRecord(){
   if($("#user_usermanager_addform").form("validate")){
   	  //console.info($("#user_usermanager_addform input[name=name]").val());
     $.ajax({
      type : 'POSt',
      url : getRequestPath('userAction!save.action'),
      async : true,
      datatype : 'json',
      data : $("#user_usermanager_addform").serialize(),
      success : function(data){
      	var obj=jQuery.parseJSON(data);
      	console.info(obj);
         $("#user_usermanager_addDialog").dialog('close');
         userdatagrid.datagrid('insertRow',{
           index:0,
           row:obj.obj
         });
      }
     });
   }else{
    $.messager.alert("提示","表单验证失败！",'warning');
   }
}
function editRecord(){
	var row=userdatagrid.datagrid('getSelections');
     if(row.length==1){
     var d = $('<div/>').dialog({
      width:540,
      height:260,
      title:'修改',
      modal:true,
      href:getRequestPath('user/usermanager/edituser.jsp'),
      buttons:[{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
           $('#user_usermanager_editform').form('submit', {    
           url : getRequestPath('userAction!edit.action'),       
           success : function(data){    
             var obj=jQuery.parseJSON(data);
             if(obj.success){
             	//console.info(d);
               d.dialog('close');
               userdatagrid.datagrid('updateRow',{
	              index: userdatagrid.datagrid('getRowIndex',row[0].id),
	              row: obj.obj
               });
               userdatagrid.datagrid('unselectAll');
               }
              $.messager.show({title:'提示',msg:obj.msg});
             }    
            }); 
           }
          }],
          onLoad:function(){
            $('#user_usermanager_editform').form('load',row[0]);
              
            },
            onClose:function(){
               $(this).dialog('destroy');
            }
           });
      }else if(row.length>1){
       	  $.messager.alert('提示','同时只能编辑一行','error');
      }else{
       	  $.messager.alert('提示','请选择要编辑的行','question');
      }
  
}
function deleteRecord(){
        var ids=[];
       	var rows=userdatagrid.datagrid('getSelections');
       	 if(rows.length>0){
       	    $.messager.confirm('确认','您是否真的要删除选中的项？',function(del){
       	       if(del){
       	        for(var i=0;i<rows.length;i++){
       	           ids.push(rows[i].id);
       	         }
       	       var keyids=ids.join(',');
       	       console.info(keyids);
       	       $.ajax({
       	           type:'POST',
       	           url:getRequestPath('userAction!remove.action'),
       	           data:{ids:keyids},
       	           async:'true',
       	          // datatype:'json',
       	           success:function(data){
       	           	  var obj=jQuery.parseJSON(data);
       	              userdatagrid.datagrid('load');
       	              $.messager.show({
       	              title : '提示',
       	              msg : obj.msg
       	              });
       	           }
       	          });
       	        }
       	      });
       	     }else{
       	        $.messager.alert("提示",'请选择要删除的行','warning');
       	     }
}
function addRow(){
	if(editRow!=undefined){
	  userdatagrid.datagrid('beginEdit',editRow);
	}
	if(editRow==undefined){
     userdatagrid.datagrid('insertRow',{
       index : 0,
       row : {
          name:'',
          pwd:'',
          createdatetime:'',
          modifydatetime:''
       }
     });
     changeEditorAddRow();
     userdatagrid.datagrid('beginEdit',0);
     editRow=0;
	}
}
function editRowdata(){
	var row=userdatagrid.datagrid('getSelected');
	//此处要注意一个问题getSelections和getChecked获得的都是数组，所以如果这里用这个方法，getRowIndex后面应该是row[0]
	if(editRow!=undefined){
		userdatagrid.datagrid('endEdit',editRow);
	}else{
	  var rowIndex=userdatagrid.datagrid('getRowIndex',row);
      console.info(rowIndex);
      changeEditorEditRow();
      userdatagrid.datagrid('beginEdit',rowIndex);
      editRow=rowIndex;
      userdatagrid.datagrid('unselectAll');
	}
}
function changeEditorEditRow() {/*编辑行时，改变editor*/
		//userdatagrid.datagrid('removeEditor', 'pwd');
		userdatagrid.datagrid('addEditor', [ {
			field : 'createdatetime',
			editor : {
				type : 'datetimebox',
				options : {
					editable : false
				}
			}
		}, {
			field : 'modifydatetime',
			editor : {
				type : 'datetimebox',
				options : {
					editable : false
				}
			}
		} ]);
	}
function changeEditorAddRow() {/*添加行时，改变editor*/
		userdatagrid.datagrid('addEditor', {
			field : 'pwd',
			editor : {
				type : 'validatebox',
				options : {
				required : true
				}
			}
		});
		userdatagrid.datagrid('removeEditor', [ 'createdatetime', 'modifydatetime' ]);
}