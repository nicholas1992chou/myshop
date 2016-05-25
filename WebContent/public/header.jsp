<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="shop"></c:set>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<link rel="stylesheet"
	href="${shop }/jquery-easyui-1.4.5/themes/default/easyui.css" />
<link rel="stylesheet"
	href="${shop }/jquery-easyui-1.4.5/themes/icon.css" />
<link rel="stylesheet" href="${shop }/css/home-header.css" />
<script type="text/javascript"
	src="${shop }/jquery-easyui-1.4.5/jquery.min.js"></script>
<script type="text/javascript"
	src="${shop }/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${shop }/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${shop }/jquery-validation-1.14.0/lib/jquery-1.11.1.js"></script>
<script type="text/javascript"
	src="${shop }/jquery-validation-1.14.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="${shop }/js/home-header.js"></script>
<script type="text/javascript" src="${shop }/js/register-validate.js"></script>
<body>
	<div id="head">
		<ul>
			<li><a href="${shop }/index.jsp">home</a></li>
			<li><a href="#">male</a>
				<div class="inner">
					<ul>
						<li><a href="#">鞋类</a></li>
						<li><a href="#">足球</a></li>
						<li><a href="#">篮球</a></li>
						<li><a href="#">户外</a></li>
						<li><a href="#">休闲</a></li>
						<li><a href="#">跑步</a></li>
					</ul>
					<ul>
						<li><a href="#">服饰类</a></li>
						<li><a href="#">长袖</a></li>
						<li><a href="#">短袖</a></li>
						<li><a href="#">休闲</a></li>
						<li><a href="#">夹克</a></li>
						<li><a href="#">卫衣</a></li>
					</ul>
					<ul>
						<li><a href="#">配件</a></li>
						<li><a href="#">项链</a></li>
						<li><a href="#">指环</a></li>
						<li><a href="#">戒指</a></li>
						<li><a href="#">手环</a></li>
						<li><a href="#">手表</a></li>
					</ul>
				</div></li>
			<li><a href="#">famale</a>
				<div class="inner">
					<ul>
						<li><a href="#">鞋类</a></li>
						<li><a href="#">足球</a></li>
						<li><a href="#">篮球</a></li>
						<li><a href="#">户外</a></li>
						<li><a href="#">休闲</a></li>
						<li><a href="#">跑步</a></li>
					</ul>
					<ul>
						<li><a href="#">服饰类</a></li>
						<li><a href="#">长袖</a></li>
						<li><a href="#">短袖</a></li>
						<li><a href="#">休闲</a></li>
						<li><a href="#">夹克</a></li>
						<li><a href="#">卫衣</a></li>
						<li><a href="#">长裙</a></li>
						<li><a href="#">短裙</a></li>
					</ul>
					<ul>
						<li><a href="#">配件</a></li>
						<li><a href="#">项链</a></li>
						<li><a href="#">指环</a></li>
						<li><a href="#">戒指</a></li>
						<li><a href="#">手环</a></li>
						<li><a href="#">手表</a></li>
					</ul>
				</div></li>
			<li><a href="#">sports</a>
				<div class="inner">
					<ul>
						<li><a href="#">足球</a></li>
						<li><a href="#">篮球</a></li>
						<li><a href="#">户外</a></li>
						<li><a href="#">休闲</a></li>
						<li><a href="#">跑步</a></li>
					</ul>
					<ul>
						<li><a href="#">篮球</a></li>
						<li><a href="#">长袖</a></li>
						<li><a href="#">短袖</a></li>
						<li><a href="#">休闲</a></li>
						<li><a href="#">夹克</a></li>
						<li><a href="#">卫衣</a></li>
						<li><a href="#">长裙</a></li>
						<li><a href="#">短裙</a></li>
					</ul>
					<ul>
						<li><a href="#">户外</a></li>
						<li><a href="#">项链</a></li>
						<li><a href="#">指环</a></li>
						<li><a href="#">戒指</a></li>
						<li><a href="#">手环</a></li>
						<li><a href="#">手表</a></li>
					</ul>
				</div></li>
		</ul>
		<div id="sc">
			<div class="search">search</div>
			<div class="login">login</div>
			<div class="register">register</div>
		</div>
		<div id="searchbox">
			<form action="" method="post">
				<input class="text" type="text" name="name"
					style="width: 100%; height: 50px;" /> <input class="submit"
					type="submit" value="go" />
			</form>
			<div id="cancel">X</div>
		</div>

	</div>
	<div id="login">
		<div class="interceptor">
			login before shopping please
		</div>
		<div class="error">
			username is invalid or password is wrong
		</div>
		<div class="closeicon">
			<img src="/myshop/icon/close/x.png" style="width: 35px;">
		</div>
		<form id = "login_form" action="" method="post">
			<table>
				<tr>
					<td><label for="name">userName</label></td>
				</tr>
				<tr>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td><label for="password">password</label></td>
				</tr>
				<tr>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td><div class="go">login</div></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="register">
		<div class="tittle">register</div>
		<div class="head1"></div>
		<div class="head2"></div>
		<div class="close">
			<img alt="" src="/myshop/icon/close/delete_x_d.png" height="40px">
		</div>
		<form id = "register_form" action="" method="post">
			<table>
				<tr>
					<td><label for="name">userName:</label></td>
					<td><input type="text" name="name" /></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td><label for="register_password">password:</label></td>
					<td><input id = "register_password" type="password" name="password" /></td>
					<td></td>
				</tr>
				<tr>
					<td><label for="register_confirm">confirm:</label></td>
					<td><input  id = "register_confirm" type="password" name="confirm" /></td>
					<td></td>
				</tr>
				<tr>
					<td><label for="sex">sex:</label></td>
					<td><input type="radio" name="sex" checked="checked"
						value="male" />male &nbsp; <input type="radio" name="sex"
						value="female" />female</td>
					<td></td>
				</tr>
				<tr>
					<td><label for="phone">cell phone:</label></td>
					<td><input type="text" name="phone" /></td>
					<td></td>
				</tr>
				<tr>
					<td><label for="email">email:</label></td>
					<td><input type="text" name="email" /></td>
					<td></td>
				</tr>
			</table>
			<input type="submit" value="submit" />
			<div class="reset">reset</div>
		</form>
	</div>
	<div id="lock"></div>
</body>
</html>