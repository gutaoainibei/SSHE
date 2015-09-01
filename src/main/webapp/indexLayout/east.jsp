<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<body>
 <script type="text/javascript" src="myJs/east.js"></script>
 <div id="east_layout" class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north'" style="height:180px;overflow: hidden;">
      <div id="mycalendar"></div>
    </div>
    <div data-options="region:'center',border:false" style="overflow: hidden;">
       <div id="onlinePanel" data-options="fit:true,border:false" title="在线列表">
          <table id="onlineDatagrid"></table>
      </div>
    </div>
 </div>
</body>

