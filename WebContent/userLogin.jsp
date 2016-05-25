<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<!-- head.jsp includes the environment of easyUI and taglibs and the path of app-->
<%@include file="public/head.jsp"%>
<title>用户登录</title>
	
</head>
<body>
	<s:form action="customer_login.action" method="post">
		<s:textfield  name="name" label="userName"></s:textfield>
		<s:password name="password" label="password"></s:password>
		<s:submit value="login" ></s:submit>	
	</s:form>

</body>
</html>