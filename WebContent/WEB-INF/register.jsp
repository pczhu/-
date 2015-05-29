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
						$("#registerform")
								.validate(
										{
											rules : {
												username : {
													required : true,
													rangelength : [ 2, 15 ]
												},
												userpassword : {
													required : true,
													rangelength : [ 5, 25 ]
												},
												userrepassword : {
													required : true,
													equalTo : "#userpassword"
												},

											},
											messages : {
												username : {
													required : "用户名不能为空",
													rangelength : jQuery.validator
															.format("请输入 一个长度介于 {0} 和 {1} 之间的用户名"),
												},
												userpassword : {
													required : "密码不能为空",
													rangelength : jQuery.validator
															.format("请输入 一个长度介于 {0} 和 {1} 之间的密码"),
												},
												userrepassword : {
													required : "重填密码不能为空",
													equalTo : "密码不同，请重新输入",
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
<script type="text/javascript">
	function gotoDelete(n) {
		var id = n.id;
		window.location.href = "/ZhuNewsManager/delete?newsID=" + id;
	}
	function gotoshow(n) {
		var id = n.id;
		window.location.href = "/ZhuNewsManager/canshow?newsID=" + id;
	}
	function getDate(tm) {
		var tt = new Date(parseInt(tm) * 1000).toLocaleString().replace(/年|月/g,
				"-").replace(/日/g, " ")
		return tt;
	}
	function change_div(id) {
		if (id == 'gsywly') {
			document.getElementByIdx_x("gsgs").style.display = 'none';
			document.getElementByIdx_x("gsywly").style.display = 'block';
		} else {
			document.getElementByIdx_x("gsywly").style.display = 'none';
			document.getElementByIdx_x("gsgs").style.display = 'block';
		}
	}
	9
</script>
<style type="text/css">
#gsywly {
	display: none;
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
											<c:if test="${sessionScope.logininfo.userPower == 2}">
												<h1 class="type">
													<a href="javascript:void(0)">用户管理</a>
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
															href="/ZhuNewsManager/forwardJsp?target=register.jsp"
															target="main">用户注册</a></li>
														<li><a href="/ZhuNewsManager/showusers" target="main">用户列表</a></li>

													</ul>

												</div>
											</c:if>
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
											<form id="registerform" name="registerform" method="post"
												action="/ZhuNewsManager/register">
												<table width="600" border="0" align="center" class="b">
													<tr>
														<td colspan="2" align="center"><h1>新用户注册</h1></td>
													</tr>
													<tr>
														<td width="167" align="right">用户名(<font color="red">*</font>)：
														</td>
														<td><input name="username" type="text" id="username"
															size="25" /></td>
													</tr>
													<tr>
														<td align="right">密码(<font color="red">*</font>)：
														</td>
														<td><input name="userpassword" type="password"
															id="userpassword" size="25" /></td>
													</tr>
													<tr>
														<td align="right">确认密码(<font color="red">*</font>)：
														</td>
														<td><input name="userrepassword" type="password"
															id="userrepassword" size="25" /></td>
													</tr>
													<tr>
														<td>&nbsp;</td>
														<td><input type="submit" name="submit" id="send"
															value="确认提交" /> <input type="reset" name="reset"
															id="reset" value="全部重写" /></td>
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
