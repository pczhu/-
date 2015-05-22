<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function gotoDelete(n) {
		var id = n.id;
		window.location.href = "/ZhuNewsManager/delete?newsID=" + id;
	}
	function gotoshow(n) {
		var id = n.id;
		window.location.href = "/ZhuNewsManager/canshow?newsID=" + id;
	}
	function getDate(tm){ 
		var tt=new Date(parseInt(tm) * 1000).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ") 
		return tt; 
	}
</script>
</head>
<body>
	欢迎
	<c:choose>
		<c:when test="${sessionScope.logininfo == null}">
			<button value="管理员登陆" onclick="window.location.href='/ZhuNewsManager/forwardJsp?target=login.jsp'"></button>
		</c:when>
		<c:otherwise>
		
		${sessionScope.logininfo.userName}
		<a href="/ZhuNewsManager/logout">退出</a>
			<a href="/ZhuNewsManager/forwardJsp?target=addNews.jsp">发布新闻</a>
			<a href="/ZhuNewsManager/welcome.jsp">首页</a>
			<table name="newslist" border="1">
				<tr>
					<td>新闻标题</td>
					<td>新闻时间</td>
					<td>新闻简介</td>
					<td>审核状态</td>
					<td>删除</td>
					<c:if test="${sessionScope.logininfo.userPower == 2}">
						<td>审核</td>
					</c:if>
				</tr>
				<c:if test="${sessionScope.logininfo != null}">
					<c:forEach var="newslists" items="${sessionScope.newslist}">
						<tr>
							<td>${newslists.newstitle}</td>
							<td>${newslists.newsdateTime}</td>
							<td>${newslists.newsdesc}</td>

							<td><c:choose>
									<c:when test="${newslists.newscheckup == 1}">
									审核通过
									</c:when>
									<c:otherwise>
									未审核通过
									</c:otherwise>
								</c:choose></td>

							<td><input id="${newslists.newsID}"
								onclick="gotoDelete(this)" type="button" name="shanchu"
								value="删除" onclick=""></td>
							<c:if test="${sessionScope.logininfo.userPower == 2}">
								<td><input id="${newslists.newsID}"
									onclick="gotoshow(this)" type="button" name="tongguo"
									value="通过"></td>
							</c:if>
						</tr>
					</c:forEach>
				</c:if>

			</table>

		</c:otherwise>
	</c:choose>
</body>
</html>