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
	var dg = parent.$("iframe[src='send_product_query.action']").get(0)
	.contentWindow.$("#dg");
	//get selections
	var rows = dg.datagrid("getSelections");
	
	//远程方式创建表单，并回显。数据来自当初选中的记录
	$("#ff").form("load",{
		id:rows[0].id,
		name:rows[0].name,
		amount:rows[0].amount,
		price:rows[0].price,
		picture:rows[0].picture,
		remark:rows[0].remark,
		dremark:rows[0].dremark,
		commend:rows[0].commend,
		
		//json格式中级联对象的表示
		'category.id':rows[0].category.id
	});
	//create a combobox to get admins
	$('#cc').combobox({    
	    url:'category_query.action',    
	    valueField:'id',    
	    textField:'cname' ,
	    required:true,
	    missingMessage:'请选择',
	    editable:false
	});
	//validate form
	$("textarea[name=name]").validatebox({
		required:true,
		missingMessage:'请输入名称'
	});
	
	$("input[name=amount]").numberbox({
		required:true,
		missingMessage:'请输入库存',
		min:1   
	});
	$("input[name=price]").numberbox({
		required:true,
		missingMessage:'请输入价格',
		min:0,    
		precision:2,
		prefix:'￥'
	});
	$("input[type=file]").validatebox({
		required:true,
		missingMessage:'请选择图片'
	});
	$("textarea[name=remark]").validatebox({
		required:true,
		missingMessage:'简单描述'
	});
	$("textarea[name=dremark]").validatebox({
		required:true,
		missingMessage:'详细描述'
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
				url:'product_update.action',
				success:function(data){
					if(data == "true"){
						parent.$("#win").window("close");
						//clear Selections
						dg.datagrid("clearSelections");
						//refresh datagrid
						dg.datagrid("reload");
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
	<form id="ff" method="post" enctype="multipart/form-data">   
     <div>   
        <label for="name">产品名称:</label>   
        <textarea rows="2" cols="30" name="name"></textarea>  
    </div> 
     <div>   
        <label for="amount">产品库存:</label>   
       <input class = "easyui-validatebox" type="text" name="amount"/>
    </div> 
    <div>   
        <label for="price">产品价格:</label>   
        <input class="easyui-validatebox" type="text" name="price" />   
    </div>  
    <div>   
        <label for="srcFile">图片路径:</label>   
        <input class="easyui-validatebox" type="file" name="srcFile"/>
    </div>  
    <div>   
        <label for="remark">产品描述:</label>   
       <textarea rows="2" cols="30" name="remark"></textarea>   
    </div> 
    <div>   
        <label for="dremark">产品细节:</label>   
		<textarea rows="2" cols="30" name="dremark"></textarea> 
    </div> 
    <div>   
        <label for="commend">是否推荐:</label> 
        是：<input  type="radio" name="commend" value = "true"  />
	否： <input  type="radio" name="commend" value = "false"  checked="checked" />      
    
    </div> 
    <label for="category.id">所属类别:</label>
    <input id="cc" name="category.id" >   
    <div>
    
    <!-- 提交按钮 -->
    <a id="btn" href="#" class="easyui-linkbutton">更新</a> 
    
	<!-- 需要更新的product 的 id -->
    <input type = "hidden" name = "id" />
    </div>  

    
</form>  

	
</body>
</html>