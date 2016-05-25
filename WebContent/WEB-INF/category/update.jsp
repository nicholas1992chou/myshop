<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/public/head.jsp" %>
<style type="text/css">
	form div{
		margin: 5px;
	}
</style>
<script type="text/javascript">

$(document).ready(function(){
	var dg = parent.$("iframe[src='send_category_query.action']").get(0)
	.contentWindow.$("#dg");
	//get selections
	var rows = dg.datagrid("getSelections");
	
	//远程方式创建表单，并回显。数据来自当初选中的记录
	$("#ff").form("load",{
		id:rows[0].id,
		cname:rows[0].cname,
		hot:rows[0].hot,
		//json格式中级联对象的表示
		'account.id':rows[0].account.id
	});
	//create a combobox to get admins
	$('#cc').combobox({    
	    url:'account_query.action',    
	    valueField:'id', //valueField为下拉列表中option的实际值  此id为返回json数据里account对象的id 
	    textField:'aname' ,//文本框中显示的值。此aname为返回json数据里account对象的aname 
	    
	    editable:false
	});
	//validate form
	$("input[name='cname']").validatebox({
		required:true,
		MissingMessage:'请输入'
	});
	//禁止验证
	$("#ff").form("disableValidation");
	//提交表单
	$("#btn").click(function(){
		//点击按钮，验证表单
		$("#ff").form("enableValidation");
		//验证通过
		if($("#ff").form("validate")){
			//设置隐藏域id的值
			$("input[name='id']").val(rows[0].id);
			//提交表单
			$("#ff").form('submit', {
				url:'category_update.action',
				success:function(data){
					if(data == "true"){
						parent.$("#win").window("close");
						//清除所有页面选中行。
						parent.$("iframe[src='send_category_query.action']").get(0)
						.contentWindow.$("#dg").datagrid('clearSelections');
						//refresh datagrid
						parent.$("iframe[src='send_category_query.action']").get(0)
						.contentWindow.$("#dg").datagrid("load");
					}else{
						alert('更新失败，请重新尝试');
					}
				}
			});
		}
	});
});
</script>
</head>
<body>
	<form id="ff" method="post">   
    <div>   
        <label for="cname">类别名称:</label>   
        <input class="easyui-validatebox" type="text" name="cname" />   
    </div>   
    <div>   
        <label for="hot">热点:</label> 
        热点：<input  type="radio" name="hot" value = "true"  />
    非热点： <input  type="radio" name="hot" value = "false"  checked="checked" />      
    </div> 
     
    <!-- 远程方式创建下拉列表 -->
  	  所属管理员：
    <input id="cc" name="account.id">  
    <div>
    
    <!-- 提交按钮 -->
    <a id="btn" href="#" class="easyui-linkbutton">更新</a> 
    
	<!-- 需要更新的category 的 id -->
    <input type = "hidden" name = "id" />
    </div>  

    
</form>  

	
</body>
</html>