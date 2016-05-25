<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<!-- head.jsp includes the environment of easyUI and taglibs-->
<%@include file="public/header.jsp"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<style type="text/css">

#bigWrapper {
	width: 1000px;
	margin: 0 auto;
	padding: 1px;
	border: 2px solid #aaa;
}

h2 {
	padding: 5px;
	display: block;
	text-align:center;
	font: 14px;
	color: rgb(23,23,23);
	margin-bottom: 5px;
	background: rgb(223,223,223);
}

#bigWrapper ul {
	margin:0px;
	padding: 0;
	width: 100%;
	height: 365px;
	
}

#bigWrapper ul li {
	list-style: none;
	
	width: 230px;
	margin-right: 10px;
	float: left;
	border: 5px solid rgb(223,223,223);
	border-radius:3px;
}

#bigWrapper ul li img {
	width: 100%;
	height: 280px;
	
}

#bigWrapper ul li a[lang="#"] {
	display: block;
	//background: rgb(151,169,179);
	color:rgb(82,143,222);
	height: 40px;
	padding:0 4px;
	text-align:center;
	text-decoration: none;
}

#bigWrapper a:HOVER {
	text-decoration: underline;
	color:#fff;
}

#price {
color:silver;
	text-align: left;
	padding: 2px 5px;
}
</style>
</head>
<body>
	<div id="bg">
		<ul >
			<li><img src="${shop }/img/kobe1.jpg"></li>
			<li><img src="${shop }/img/kobe2.jpg"></li>
			<li><img src="${shop }/img/kobe3.jpg"></li>
			<li><img src="${shop }/img/kobe4.jpg"></li>
			<li><img src="${shop }/img/wang1.jpg"></li>
			<li><img src="${shop }/img/wang2.jpg"></li>
			<li><img src="${shop }/img/wang3.jpg"></li>
			<li><img src="${shop }/img/wang4.jpg"></li>
			<li><img src="${shop }/img/kobe5.jpg"></li>
			<li><img src="${shop }/img/kobe1.jpg"></li>
			<li><img src="${shop }/img/kobe2.jpg"></li>
			<li><img src="${shop }/img/kobe3.jpg"></li>
			<li><img src="${shop }/img/kobe4.jpg"></li>
			<li><img src="${shop }/img/wang1.jpg"></li>
			<li><img src="${shop }/img/wang2.jpg"></li>
			<li><img src="${shop }/img/wang3.jpg"></li>
			<li><img src="${shop }/img/wang4.jpg"></li>
			<li><img src="${shop }/img/kobe5.jpg"></li>
		</ul>
	</div>
	<div id="bigWrapper">
		<c:forEach items="${bigList }" var="category">
			<c:if test="${category != null}">
				<h2>${category[0].getCategory().getCname() }</h2>
				<ul>
					<c:forEach items="${category}" var="product">
						<li> <a
							href="${shop }/product_get.action?id=${product.getId() }"><img src="/myshop/image/${product.getPicture() }" /></a> 
						<a lang="#"
							href="${shop }/product_get.action?id=${product.getId() }">${product.getName() }</a>
							<hr style="width: 90%; margin: 0 auto;">
							<div id="price">￥ ${product.getPrice() }</div></li>
					</c:forEach>
				</ul>
			</c:if>
		</c:forEach>
	</div>
</body>

</html>