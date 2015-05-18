<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="refresh" content="3,url=/ZhuNewsManager/welcome.jsp">
<title>成功</title>
<script language="javascript" type="text/javascript">
	var second = document.getElementById('totalSecond').textContent;

	if (navigator.appName.indexOf("Explorer") > -1) {
		second = document.getElementById('totalSecond').innerText;
	} else {
		second = document.getElementById('totalSecond').textContent;
	}
	setInterval("redirect()", 1000);
	function redirect() {
		if (second < 0) {
			location.href = '/ZhuNewsManager/addNews.jsp';
		} else {
			if (navigator.appName.indexOf("Explorer") > -1) {
				document.getElementById('totalSecond').innerText = second--;
			} else {
				document.getElementById('totalSecond').textContent = second--;
			}
		}
	}
</script>
</head>
<body>
	成功
	<span id="totalSecond">3</span>秒后跳转
</body>
</html>