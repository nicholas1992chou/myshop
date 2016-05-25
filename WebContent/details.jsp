<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@include file="public/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" href="${shop }/css/details.css" />
<script type="text/javascript" src="${shop }/js/details.js"></script>
</head>
<body>
	<div id="bigWrapper">
		<table>
			<tr>
				<td rowspan="5"><img
					src="${shop }/image/${requestScope.model.getPicture() }" /></td>
				<td><span>商品名称：${requestScope.model.getName()}</span></td>
			</tr>
			<tr>
				<td><span>商品描述：${requestScope.model.getRemark()}</span></td>
			</tr>
			<tr>
				<td><span>商品原价：￥<span lang="${requestScope.model.getPrice()}" style="text-decoration: line-through;">${requestScope.model.getPrice()}</span></span></td>
			</tr>
			<tr>
				<td><span>商品价格：￥${requestScope.model.getPrice()}</span></td>
			</tr>
			<tr>
				<td>配送至：</td>
			</tr>
		</table>
		<a id="cart"
			href="${shop }/sorder_addSorder.action?product.id=${requestScope.model.getId()}">加入购物车</a>
		<div id="details">
			<h2>产品详情</h2>
		</div>
	</div>
</body>
</html>