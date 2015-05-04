<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="form" name="form" method="post" action="success.html"
		onSubmit="return on_submit()">
		<table width="600" border="0" align="center" class="b">
			<tr>
				<td colspan="2" align="center"><h1>新用户注册</h1></td>
			</tr>
			<tr>
				<td width="167" align="right">用户名(<font color="red">*</font>)：</td>
				<td><input name="username" type="text" id="username" size="25"
					class="text_box"></td>
			</tr>
			<tr>
				<td align="right">密码(<font color="red">*</font>)：</td>
				<td><input name="userpsd" type="password" id="userpsd"
					size="25" class="text_box"></td>
			</tr>
			<tr>
				<td align="right">确认密码(<font color="red">*</font>)：</td>
				<td><input name="repsd" type="password" id="repsd" size="25"
					class="text_box"></td>
			</tr>
			<tr>
				<td align="right">性别：</td>
				<td><p>
						<input type="radio" name="sex" value="单选" id="sex_0"> 男 <input
							type="radio" name="sex" value="单选" id="sex_1"> 女
					</p></td>
			</tr>
			<tr>
				<td align="right">出生年月：</td>
				<td><input name="year" type="text" id="year" size="4"
					maxlength="4" class="text_box"> 年 <select name="month"
					id="month">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
				</select> 月 <input name="data" type="text" id="data" size="5" maxlength="2"
					class="text_box"></td>
			</tr>
			<tr>
				<td align="right">电子邮箱(<font color="red">*</font>)：</td>
				<td><input name="email" type="text" id="email" size="25"
					class="text_box"></td>
			</tr>
			<tr>
				<td align="right">家庭地址：</td>
				<td><input name="adr" type="text" id="adr" size="25"
					class="text_box"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" name="submit" id="send" value="确认提交">
					<input type="submit" name="reset" id="reset" value="全部重写">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>