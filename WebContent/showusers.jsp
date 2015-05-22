<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
function gotodel(n) {
	var id = n.id;
	window.location.href = "/ZhuNewsManager/delusers?userid=" + id;
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
			<a href="/ZhuNewsManager/welcome.jsp">首页</a>
			<table class="newslist" border="1">
				<tr>
					<td>用户名</td>
					<td>用户注册时间</td>
					<td>用户权限</td>
					<c:if test="${sessionScope.logininfo.userPower == 2}">
						<td>删除</td>
					</c:if>
				</tr>
				<c:if test="${sessionScope.logininfo != null}">
					<c:forEach var="userlists" items="${sessionScope.userlist}">
						<tr>
							<td>${userlists.userName}</td>
							<td>${userlists.registerTime}</td>
							<td>
								<c:choose>
									<c:when test="${userlists.userPower == 1}">
									新闻管理员
									</c:when>
									<c:otherwise>
									超级管理员
									</c:otherwise>
								</c:choose>
							</td>

							<c:if test="${sessionScope.logininfo.userPower == 2}">
								<td>
									<c:choose>
									<c:when test="${userlists.userPower == 1}">
										<input id="${userlists.userid}" onclick="gotodel(this)" type="button" name="tongguo" value="删除">
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose>
									
								</td>
							</c:if>
						</tr>
					</c:forEach>
				</c:if>

			</table>

		</c:otherwise>
	</c:choose>
</body>
</html>