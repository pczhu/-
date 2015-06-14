<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理页面</title>
<!-- 调用CSS，JS -->
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/body.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/screen.css" />
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
															.format("请输入 一个长度介于 {0} 和 {1} 之间的标题"),
												},

												picimgurl : "图片不能为空",

												picusername : "管理员账户不能为空",
												userpassword : "密码不能为空",
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
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="74" colspan="2" background="images/index1_03.gif">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="33%" rowspan="2"><a href="/ZhuNewsManager/welcome.jsp"><img src="images/logo.png"
							width="253" height="74" /></a></td>
						<td width="6%" rowspan="2">&nbsp;</td>
						<td width="61%" height="38" align="right">
							<table width="120" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td align="center" class="font2"><a
										href="/ZhuNewsManager/logout" class="font2"><strong>退出</strong></a></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td align="right">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td align="right" class="font2">
										&nbsp;|&nbsp;登陆用户：${sessionScope.logininfo.userName}&nbsp;|&nbsp;身份：
										<c:if test="${sessionScope.logininfo.userPower == 2}">管理员</c:if>
										<c:if test="${sessionScope.logininfo.userPower == 1}">发布员</c:if>
										&nbsp;|&nbsp;&nbsp;
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<table width="100%" border="0" cellspacing="10" cellpadding="0">
					<tr>
						<td width="10%" valign="top">
							<table width="100%" height="280" border="0" cellpadding="0"
								cellspacing="0" bgcolor="#EEF2FB">
								<tr>
									<td width="182" valign="top"><div id="container">
											<h1 class="type">
												<a href="javascript:void(0)">图片管理</a>
											</h1>
											<div class="content">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td><img src="images/menu_topline.gif" width="182"
															height="5" /></td>
													</tr>
												</table>
												<ul class="MM">
													<li><a
														href="/ZhuNewsManager/forwardJsp?target=addPic.jsp"
														target="main">图片发布</a></li>
													<li><a href="/ZhuNewsManager/showpics" target="main">图片列表</a></li>

												</ul>
											</div>
										</div>
										</td>
								</tr>
							</table>
						</td>
						<td width="70%" valign="top">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">

								<tr>
									<td background="images/index1_45.gif"></td>
									<td bgcolor="#FFFFFF"
										style="height: 490px; vertical-align: top; text-align: center;">
										<div id="divone">
											<form method="post" action="/ZhuNewsManager/addPics"
												enctype="MULTIPART/FORM-DATA" id="addPicsform">
												<table>
													<tr>
														<td>图片标题</td>
														<td><input type="text" name="pictitle" id="newstitle" /></td>
													</tr>

													<tr>
														<td>索引图</td>
														<td><input type="file" name="picimgurl"
															id="newsimgurl" /></td>
													</tr>

													<tr>
														<td>发布管理员</td>
														<td><input type="text" name="picusername"
															id="newsusername" /></td>
													</tr>
													<tr>
														<td>管理员密码</td>
														<td><input type="password" name="userpassword"
															id="userpassword" /></td>
													</tr>
													<tr>
														<td>...</td>
														<td><input type="submit" name="submit" id="send" value="确认提交"/>
														<input type="reset" name="reset" id="reset" value="全部重写"/></td>
													</tr>
												</table>
												
											</form>
										</div>
									</td>
									<td background="images/index1_47.gif"></td>
								</tr>
								<tr>
									<td width="8" height="8"><img src="images/index1_91.gif"
										width="8" height="8" /></td>
									<td background="images/index1_92.gif"></td>
									<td width="8" height="8"><img src="images/index1_93.gif"
										width="8" height="8" /></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
