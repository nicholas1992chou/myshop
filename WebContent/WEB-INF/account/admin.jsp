<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@taglib uri="/struts-tags" prefix="s"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>administrator</title>
<%@include file="/public/head.jsp"%>

<style type="text/css">
#menu ul {
	padding: 0;
	width: 500 px;
	//background: blue;
	margin: 0;
}

#menu ul li {
	//width: 150px;
	list-style-type: none;
	margin-bottom: 1px;
}

#menu ul li a {
	display: block;
	text-align: center;
	text-decoration: none;
	background-color: rgb(86,108,131);
	color: white;
	padding: 5px;
	border-radius:2px;
}

#menu ul li a:HOVER {
	background-color: rgb(2,123,192);
	color: rgb(45,45,45);
}
</style>

<script type="text/javascript">
	$(document).ready(function (){
		$("a[title]").click(function(){
			var text = $(this).text();
			var href = $(this).attr("title");
			if($("#tt").tabs("exists", text)){
				$("#tt").tabs("select", text);
			}else{
				$("#tt").tabs("add", {
					title:text,
					closable:true,
					content:"<iframe src='" + href + "'frameborder = 0 width=100% height = 100% />"
				});
			}
		});
	});
	
</script>
</head>

<body class="easyui-layout" >
	<div data-options="region:'north',title:'管理系统',split:true,"
		style="height: 100px; "></div>
	<div data-options="region:'south',title:'South Title',split:true"
		style="height: 100px;"></div>
	<div
		data-options="region:'east',iconCls:'icon-reload',title:'East',split:true"
		style="width: 100px;">
		
	</div>
	<div data-options="region:'west',title:'系统操作',split:true"
		style="width: 150px;">
		<div id="menu" class="easyui-accordion" data-options="fit:true">
			<div title="基础操作" >
				<ul data-options="fit:true">
					<li><a href="#" title="send_category_query.action">category</a></li>
					<li><a href="#" title="send_account_query.action">admin</a></li>
					<li><a href="#" title="send_product_query.action">product</a></li>
				</ul>
			</div>
			<div title="其他操作" >
				<ul>
					<li><a href="#">category</a></li>
					<li><a href="#">admin</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div data-options="region:'center',title:'后台管理'"
		style="padding: 5px; background: #eee;">
		
		<!--选项卡  -->
		<div id="tt" class="easyui-tabs" data-options="fit:true">   
		    <!-- 默认选项 -->
		    <div title="系統缺省頁面" style="padding:20px;">   
		        系統信息 
		    </div>   
		</div>  
	</div>
	<!-- 此div 为添加类型 弹出窗口  ,只有id，没有class，不显示-->
	<div id="win"   
        data-options="modal:true, collapsible:false, 
       	minimizable:false,maximizable:false,resizable:false">   
	</div>  


</body>
</html>