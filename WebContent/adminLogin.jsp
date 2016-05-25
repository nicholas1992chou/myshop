<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<!-- head.jsp includes the environment of easyUI and taglibs and the path of app-->
<%@include file="public/head.jsp"%>
<title>用户登录</title>
	<style>
<!--
	#admin{
		width: 400px;
		height: 300px;
		background: rgb(144,144,144);
		margin: 10px auto;
		text-align: center;
		padding: 2px;
	}
	form{
		margin:110px auto;
		
		width: 260px;
	}
-->
</style>
</head>
<body>
<div id = "admin">

	<s:form action="account_login.action" method="post">
		<s:textfield  name="aname" label="userName"></s:textfield>
		<s:password name="password" label="password"></s:password>
		<s:submit value="login" ></s:submit>	
	</s:form>

</div>
</body>
</html>