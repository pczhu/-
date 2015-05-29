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
													<li><a href="/ZhuNewsManager/forwardJsp?target=addNews.jsp" target="main">新闻发布</a></li>
													<li><a href="/ZhuNewsManager/shownews" target="main">新闻列表</a></li>

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
										<c:if test="${sessionScope.newsbeandetail!=null }">
											   <table border="1" align="left">

													<tr>
														<td background="images/index1_72.gif" bgcolor="#FFFFFF">
														新闻标题
														</td>
														<td>
														${sessionScope.newsbeandetail.newsuserName}
														</td>
													</tr>
													<tr>
														<td background="images/index1_72.gif" bgcolor="#FFFFFF">
														新闻作者
														</td>
														<td>
														${sessionScope.newsbeandetail.newswriter}
														</td>
													</tr>
													<tr>
														<td background="images/index1_72.gif" bgcolor="#FFFFFF">
														新闻发布人
														</td>
														<td>
														${sessionScope.newsbeandetail.newsuserName}
														</td >
													</tr>
													<tr>
														<td background="images/index1_72.gif" bgcolor="#FFFFFF">
														新闻来源
														</td>
														<td>
														${sessionScope.newsbeandetail.newssource}
														</td>
													</tr>
													<tr>
														<td background="images/index1_72.gif" bgcolor="#FFFFFF">
														新闻时间
														</td>
														<td>
														${sessionScope.newsbeandetail.newsdateTime}
														</td>
													</tr>
													<tr>
														<td background="images/index1_72.gif" bgcolor="#FFFFFF">
														新闻类型
														</td>
														<td>
														${sessionScope.newsbeandetail.newsType}
														</td>
													</tr>
													<tr>
														<td background="images/index1_72.gif" bgcolor="#FFFFFF">
														新闻简介
														</td>
														<td width="50%">
														<span  >${sessionScope.newsbeandetail.newsdesc}</span>
														
														</td>
													</tr>
													<tr>
														<td background="images/index1_72.gif" bgcolor="#FFFFFF">
														新闻内容
														</td>
														<td width="50%">
														<span  >${sessionScope.newsbeandetail.newscontent}</span>
														
														</td>
													</tr>
													<tr>
													<td background="images/index1_72.gif" bgcolor="#FFFFFF">审核状态</td>
													<td height="26" align="center" bgcolor="#FFFFFF">
													<c:choose>
														<c:when test="${sessionScope.newsbeandetail.newscheckup == 1}">
															审核通过
														</c:when>
															<c:otherwise>
															未审核通过
															</c:otherwise>
													</c:choose>
													</td>
													</tr>
													<tr>
													<td height="26" align="center" bgcolor="#FFFFFF">
														<img src="images/index_del.gif" alt="images/index_del.gif" id="${sessionScope.newsbeandetail.newsID}" onclick="gotoDelete(this)" />
													</td>
													<c:if test="${sessionScope.logininfo.userPower == 2}">
														<td height="26" align="center" bgcolor="#FFFFFF">
															<img src="images/index_pass.gif" alt="images/index_pass.gif" id="${sessionScope.newsbeandetail.newsID}" name="tongguo" onclick="gotoshow(this)" />
														</td>
													</c:if>
												</tr>
												</table>		
										
										</c:if>

										</div>
									</td>
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
