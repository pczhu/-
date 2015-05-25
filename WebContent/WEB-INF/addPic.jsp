<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/screen.css">
<script src="js/jquery.js"></script>
<script src="js/jquery.validate.js"></script>
<script type="text/javascript">
	$()
			.ready(
					function() {
						$("#addPicsform")
								.validate(
										{
											rules : {
												pictitle : {
													required : true,
													rangelength : [ 2, 15 ]
												},
												picimgurl : "required",

												picusername : "required",
												userpassword : "required",

											},
											messages : {
												pictitle : {
													required : "新闻标题不能为空",
													rangelength : jQuery.validator
															.format("请输入 一个长度介于 {0} 和 {1} 之间的字符串"),
												},

												picimgurl : "缩略图不能为空",

												picusername : "管理员账户不能为空",
												userpassword : "不能为空",
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
	<c:if test="${sessionScope.logininfo!= null}">
			${sessionScope.logininfo.userName}
		<a href="/ZhuNewsManager/logout">退出</a>
		<a href="/ZhuNewsManager/welcome.jsp">首页</a>
	</c:if>
	<form method="POST" action="/ZhuNewsManager/addPics"
		enctype="MULTIPART/FORM-DATA" id="addPicsform">
		<table>
			<tr>
				<td>图片标题</td>
				<td><input type="text" name="pictitle" id="newstitle"></td>
			</tr>

			<tr>
				<td>索引图</td>
				<td><input type="file" name="picimgurl" id="newsimgurl"></td>
			</tr>

			<tr>
				<td>发布管理员</td>
				<td><input type="text" name="picusername" id="newsusername"></td>
			</tr>
			<tr>
				<td>管理员密码</td>
				<td><input type="password" name="userpassword"
					id="userpassword"></td>
			</tr>

		</table>
		<input type="submit" name="submit" id="send" value="确认提交"> <input
			type="submit" name="reset" id="reset" value="全部重写">
	</form>


</body>
</html>