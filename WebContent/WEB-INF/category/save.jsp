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
	$("input[name='cname']").validatebox({
		required:true,
		MissingMessage:'请输入'
	});
	$("#ff").form("disableValidation");
	//提交表单
	$("#btn").click(function(){
		//点击按钮，验证表单
		$("#ff").form("enableValidation");
		//验证通过
		if($("#ff").form("validate")){
			//提交表单
			$("#ff").form('submit', {
				url:'category_save.action',
				success:function(data){
					//成功后关闭窗口
					if(data == "true"){
						parent.$("#win").window("close");
						//refresh datagrid
						parent.$("iframe[src='send_category_query.action']").get(0)
						.contentWindow.$("#dg").datagrid("load");
					}else{
						alert('添加失败，请重新尝试');
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
        <label for="name">类别名称:</label>   
        <input class="easyui-validatebox" type="text" name="cname" />   
    </div>   
    <div>   
        <label for="hot">热点:</label> 
        热点：<input  type="radio" name="hot" value = "true"  />
    非热点： <input  type="radio" name="hot" value = "false"  checked="checked" />      
    </div>  
    <div>
    <a id="btn" href="#" class="easyui-linkbutton">添加</a>  
    </div>  
</form>  

	
</body>
</html>