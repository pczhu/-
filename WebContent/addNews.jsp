<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/screen.css">
<script src="js/jquery.js"></script>
<script src="js/jquery.validate.js"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#addnewsform").validate({
			rules : {
				newstitle : {
					required : true,
					rangelength : [ 2, 15 ]
				},
				newsdesc : {
					required : true,
					rangelength : [ 5, 25 ]
				},
				newscontent : {
					required : true,
					minlength : 15,
				},

				newswriter : {
					required : true,
					minlength : 2
				},
				newsimgurl : "required",
				newscontentimgurl : "required",
				
				newsusername : "required",
				userpassword : "required",
				
			},
			messages : {
				newstitle : {
					required : "新闻标题不能为空",
					rangelength : jQuery.validator.format("请输入 一个长度介于 {0} 和 {1} 之间的字符串"),
				},
				newsdesc : {
					required : "简介不能为空",
					rangelength : jQuery.validator.format("请输入 一个长度介于 {0} 和 {1} 之间的字符串"),
				},
				newscontent : {
					required : "新闻内容不能为空",
					minlength : jQuery.validator.format("请输入 一个最小长度不小于{0}的字符串"),
				},

				newswriter : {
					required : "新闻作者不能为空",
					minlength : jQuery.validator.format("请输入 一个最小长度不小于{0}的字符串"),
				},
				newsimgurl : "缩略图不能为空",
				newscontentimgurl : "内容图不能为空",
				
				newsusername : "管理员账户不能为空",
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


	<form method="POST" action="/ZhuNewsManager/addNews"
		enctype="application/form-data" id="addnewsform">
		<table>
			<tr>
				<td>新闻标题</td>
				<td><input type="text" name="newstitle" id="newstitle"></td>
			</tr>
			<tr>
				<td>新闻描述</td>
				<td><input type="text" name="newsdesc" id="newsdesc"></td>
			</tr>
			<tr>
				<td>新闻内容</td>
				<td><textarea rows="5" cols="60" name="newscontent"
						id="newscontent"></textarea></td>
			</tr>
			<tr>
				<td>新闻分类</td>
				<td><select name="newsclasstag" id="newsclasstag">
						<option value="1" selected="selected">头条</option>
						<option value="2">军事</option>
						<option value="3">娱乐</option>
						<option value="4">体育</option>
						<option value="5">财经</option>
						<option value="6">科技</option>
						<option value="7">段子</option>
						<option value="8">时尚</option>
				</select></td>
			</tr>

			<tr>
				<td>作者</td>
				<td><input type="text" name="newswriter" id="newswriter"></td>
			</tr>
			<tr>
				<td>索引图</td>
				<td><input type="text" name="newsimgurl" id="newsimgurl"></td>
			</tr>
			<tr>
				<td>新闻大图</td>
				<td><input type="text" name="newscontentimgurl"
					id="newscontentimgurl"></td>
			</tr>
			<tr>
				<td>新闻来源</td>
				<td><input type="text" name="newssource" id="newssource"></td>
			</tr>
			<tr>
				<td>发布管理员</td>
				<td><input type="text" name="newsusername" id="newsusername"></td>
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