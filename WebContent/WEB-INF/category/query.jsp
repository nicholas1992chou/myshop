<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/public/head.jsp" %>
<script type="text/javascript">

$(document).ready(function(){
	$('#dg').datagrid({  
	    url:'category_queryJoinAccount.action', 
	    queryParams: {
			cname: ''
			},
	    loadMsg:'please wait...',
	    fitColumns:true,
	    //显示分页组件
	    pagination:true,
	    //id标识字段，翻页时保留选中项。
	    idField:'id',
	    //只能选择单行，全选失效。
	    singleSelect:false,
	    striped:true,
	    nowrap:true,
	    frozenColumns:[[{field:'xyz', checkbox:true},
	                   {field:'id', title:'Id', width:100}
	    ]],
	   	//与json数据键值对应。
	    columns:[[    
	        //{field:'code',title:'Code',width:100},    
	        {field:'cname',title:'Cname',width:100,
	        	//格式化当前列，返回数据。
	        	//value 对应字段的值， row当前行记录， index 当前行角标。
	        	formatter: function(value, row, index ){
	        		return "<span title = "+ value +">" + value + "</span>"
	        }},    
	        {field:'hot',title:'Hot', width:100,
	        	formatter: function(value, row, index ){
	        		if(value)
	        			return '<input type="checkbox" checked="checked" disabled="disabled">';
	        		else
	        			return '<input type="checkbox" disabled="disabled">';
	        }},
	        //获取关联对象
	        {field:'account.aname',title:'Admin',width:100,
	        	formatter: function(value, row, index ){
	        			if(row.account != null){
	        				return row.account.aname;
	        			}
	        		
	        }}
	    ]], 
	    toolbar: [{
			iconCls: 'icon-edit',
			text: 'edit',
			handler: function(){
				var rows = $("#dg").datagrid("getSelections");
				if(rows.length != 1){
					$.messager.show({
						title:'错误提示',
						msg:'请选择记录仅一条记录',
						timeout:5000,
						showType: 'slide'
					});
				}else{
					parent.$("#win").window({
						width:330,    
					    height:400,
					    title:'更新类别',
					    content:"<iframe src='send_category_update.action' frameborder = 0 width=100% height = 100% />"
					});
				}
			}
		},'-',{
			iconCls: 'icon-add',
			text:'add',
			handler: function(){
				//#dg 父节点为admin.jsp document
				parent.$("#win").window({
					width:330,    
				    height:400,
				    title:'添加类别',
				    content:"<iframe src='send_category_save.action' frameborder = 0 width=100% height = 100% />"
				});
				}
		},'-',{
			iconCls: 'icon-remove',
			text:'remove',
			handler: function(){
				//返回所有被选中的行，当没有记录被选中的时候将返回一个空数组。				
				var rows = $('#dg').datagrid('getSelections');
				if(rows.length == 0){
					//弹出提示信息
					$.messager.show({
						title:'错误提示',
						msg:'请选择记录',
						timeout:5000,
						showType: 'slide'
					});
				}else{
					$.messager.confirm('dialog', 'confirm', function(r){
						if(r){
							var ids = "";
							//拼接id值  (1, 2, 3, 4,) 。
							for(var i = 0; i < rows.length; i++){
								ids += rows[i].id + ",";
							}
							//去掉最后一个逗号
							ids = ids.substring(0, ids.lastIndexOf(','));
							//发送ajax请求
							var url = 'category_deleteAll.action';
							var params = {ids:ids};
							$.post(url, params, function(data){
								//alert(data);data 为String类型
								if(data == "true"){
									//清除所有页面选中行。
									$("#dg").datagrid('clearSelections');
									//reload 重新加载后停留在当前页，load重新加载后回到第一页
									$("#dg").datagrid('reload');
								}else{
									$("#dg").datagrid('clearSelections');
									alert('failed');									
								}
							});
						}
					});
				}
			}
		},'-',{
			text:'<input type="text" id = "ss" name = "search"/>',
		}]

	}); 
	$('#ss').searchbox({ 
		//点击搜索执行事件
			searcher:function(value,name){ 
				//获取查询关键字value，以参数传递
				//执行datagrid 的load方法，将参数以json格式传递。
				$('#dg').datagrid('load',{
					cname:value
				});
			}, 
			prompt:'请输入值' 
		}); 
});
</script>
</head>
<body>
	<table id="dg"></table>
</body>
</html>