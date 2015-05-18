<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/screen.css">
<script src="js/jquery.js"></script>
<script src="js/jquery.validate.js"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#registerform").validate({
			rules : {
				username : {
					required : true,
				},
				userpassword : {
					required : true,
				},

				
			},
			messages : {
				username : {
					required : "用户名不能为空",
				},
				userpassword : {
					required : "密码不能为空",
				},
			}
		});
	});
</script>
<style>
#commentForm {
	width: 500px;
}

#commentForm label {
	width: 250px;
}

#commentForm label.error, #commentForm input.submit {
	margin-left: 253px;
}

#signupForm {
	width: 670px;
}

#signupForm label.error {
	margin-left: 10px;
	width: auto;
	display: inline;
}

#newsletter_topics label.error {
	display: none;
	margin-left: 103px;
}
</style>
</head>
<body>
	<c:if test="${sessionScope.loginerror != null}">
		${sessionScope.loginerror}
	</c:if>
	<form id="registerform" name="registerform" method="post" action="/ZhuNewsManager/login">
		<table width="600" border="0" align="center" class="b">
			<tr>
				<td colspan="2" align="center"><h1>登陆</h1></td>
			</tr>
			<tr>
				<td width="167" align="right">用户名(<font color="red">*</font>)：</td>
				<td><input name="username" type="text" id="username" size="25"></td>
			</tr>
			<tr>
				<td align="right">密码(<font color="red">*</font>)：</td>
				<td><input name="userpassword" type="password" id="userpassword" size="25"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" name="submit" id="send" value="确认提交">
					<input type="reset" name="reset" id="reset" value="全部重写">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>