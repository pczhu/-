<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	欢迎<br>
	<c:choose>
		<c:when test="${sessionScope.logininfo == null}">
			<input type="button" value="管理员登陆" onclick="window.location.href='login.jsp'">
		</c:when>
		<c:otherwise>
		
		${sessionScope.logininfo.userName}
		<a href="/ZhuNewsManager/logout">退出</a>
		<a href="/ZhuNewsManager/addNews.jsp">发布新闻</a>
		<a href="/ZhuNewsManager/shownews">显示新闻</a>
		<c:if test="${sessionScope.logininfo.userPower == 2}">
			<a href="/ZhuNewsManager/register.jsp">注册发布账号</a>
			<a href="/ZhuNewsManager/showusers">显示新闻管理员列表</a>
		</c:if>

		</c:otherwise>
	</c:choose>
</body>
</html>