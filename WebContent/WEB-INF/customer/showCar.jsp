<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/public/head.jsp"%>
<%@include file="/public/header.jsp"%>
<link rel="stylesheet" href="${shop }/css/cart.css" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>myCar</title>
<script type="text/javascript">
	$(function(){
		$('.cart input[type=text]').change(function(){
			var num=$(this).val();
			//判断num为整数，且大于0；
			if(!isNaN(num) && parseInt(num)== num && num>0){
				$(this).attr('lang', num);
				
				var pid=$(this).parents('tr:first').attr('lang');
				
				var url='sorder_updateSorder.action';
				var params={'amount':num, 'product.id':pid};
				
				$.post(url,params,function(data){
					$('#totalamount').html(data);
				},'text');
				$(this).parent().next().next().html(($(this).parent().next().html()*num).toFixed(2));
			}else{
				//返回原来值。
				$(this).val(parent.$(this).attr('lang'));
			}
		});
	});
</script>
</head>
<body>
	<div id="bigWrapper">

		<table class="cart" border="1">
			<tr>
				<th>商品编号</th>
				<th>商品名称</th>
				<th>购买数量</th>
				<th>商品单价</th>
				<th>小计</th>
			</tr>
			<!-- 判断购物车里订单集合的size -->
			<c:if
				test="${sessionScope.forder != null && fn:length(sessionScope.forder.getSorderSet()) != 0 }">
				<c:forEach items="${sessionScope.forder.getSorderSet() }"
					var="sorder" varStatus="num">

					<tr lang='${sorder.getProduct().getId() }'>
						<td>${sorder.getProduct().getId() }</td>
						<td><img
							src="${shop }/image/${sorder.getProduct().getPicture() }" /></td>
						<td><input name="amount" value="${sorder.getAmount() }" type="text" lang="${sorder.getAmount() }"/>  </td>
						<td>${sorder.getPrice() }</td>
						<td>
						
						${sorder.getAmount() * sorder.getPrice() }</td>
					</tr>
				</c:forEach>

			</c:if>
		</table>
		<div class="total">
		共计：￥<span id="totalamount">
		${sessionScope.forder.getTotalAmount()}</span>
		</div>
			
<h2>收货人信息</h2>
		<s:form id ="forder_save" action="forder_save.action" method="post">
			<s:textfield name="name" label="收货人"></s:textfield>
			<s:textfield name="phone" label="联系电话"></s:textfield>
			<s:textfield name="post" label="邮编"></s:textfield>
			<s:textfield name="address" label="收货地址" size="60"></s:textfield>
			<s:textfield name="message" label="留言" size="60"></s:textfield>
			<s:submit id="submit" value="check out"></s:submit>
		</s:form>
	</div>
</body>
</html>