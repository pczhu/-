<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理页面</title>
<!-- 调用CSS，JS -->
<script src="js/prototype.lite.js" type="text/javascript"></script>
<script src="js/moo.fx.js" type="text/javascript"></script>
<script src="js/moo.fx.pack.js" type="text/javascript"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/body.css" rel="stylesheet" type="text/css" />

<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	font-family: "宋体";
	font-size: 12px;
	color: #333333;
	background-color: #2286C2;
}
-->
<script type="text/javascript">
	function gotoDelete(n) {
		var id = n.id;
		window.location.href = "/ZhuNewsManager/delusers?userid=" + id;
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
														<li><a href="/ZhuNewsManager/forwardJsp?target=register.jsp" target="main">用户注册</a></li>
														<li><a href="/ZhuNewsManager/showusers" target="main">用户列表</a></li>

													</ul>

												</div>
											</c:if>
											<h1 class="type">
												<a href="javascript:void(0)">新闻管理</a>
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
														href="/ZhuNewsManager/forwardJsp?target=addNews.jsp"
														target="main">新闻发布</a></li>
													<li><a href="/ZhuNewsManager/shownews" target="main">新闻列表</a></li>

												</ul>
											</div>
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
													<li><a href="/ZhuNewsManager/forwardJsp?target=addPic.jsp" target="main">图片发布</a></li>
													<li><a href="/ZhuNewsManager/showpics" target="main">图片列表</a></li>

												</ul>
											</div>
										</div>

										</div> <script type="text/javascript">
											var contents = document
													.getElementsByClassName('content');
											var toggles = document
													.getElementsByClassName('type');

											var myAccordion = new fx.Accordion(
													toggles, contents, {
														opacity : true,
														duration : 400
													});
											myAccordion
													.showThisHideOpen(contents[0]);
										</script></td>
								</tr>
							</table>
						</td>
						<td width="70%" valign="top">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">

								<tr>
									<td background="images/index1_45.gif"></td>
									<td bgcolor="#FFFFFF"
										style="height: 490px; vertical-align: top;">
										<div id="divone">
											<table width="100%" border="0" cellspacing="10"
												cellpadding="0" class="divcheck">

												<tr>
													<td>
														<table width="100%" border="0" cellpadding="0"
															cellspacing="1" bgcolor="#BBD3EB">

															<tr>

																<td height="27" align="center"
																	background="images/index1_72.gif" bgcolor="#FFFFFF">用户名</td>
																<td height="27" align="center"
																	background="images/index1_72.gif" bgcolor="#FFFFFF">注册时间</td>
																<td height="27" align="center"
																	background="images/index1_72.gif" bgcolor="#FFFFFF">用户权限</td>



																<c:if test="${sessionScope.logininfo.userPower == 2}">
																	<td align="center" background="images/index1_72.gif"
																		bgcolor="#FFFFFF">删除</td>
																</c:if>
															</tr>
															<c:if test="${sessionScope.logininfo != null}">
																<c:forEach var="userlists"
																	items="${sessionScope.userlist}">
																	<tr>
																		<td height="26" align="center" bgcolor="#FFFFFF">${userlists.userName}</td>
																		<td height="26" align="center" bgcolor="#FFFFFF">${userlists.registerTime}</td>
																		<td height="26" align="center" bgcolor="#FFFFFF"><c:choose>
																				<c:when test="${userlists.userPower == 1}">
									新闻管理员
									</c:when>
																				<c:otherwise>
									超级管理员
									</c:otherwise>
																			</c:choose></td>





																		<c:if test="${sessionScope.logininfo.userPower == 2}">
																			<td height="26" align="center" bgcolor="#FFFFFF">
																			<c:if test="${userlists.userPower == 1}">
																																							<img src="images/index_del.gif"
																				alt="images/index_del.gif" id="${userlists.userid}"
																				onclick="gotoDelete(this)" />
																			</c:if>

																			</td>
																		</c:if>
																	</tr>
																</c:forEach>
															</c:if>


														</table>
													</td>
												</tr>
											</table>
										</div>
										<div></div>
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
