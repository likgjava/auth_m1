<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/view/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/view/common/head.jsp" %>
<title>新增用户</title>
</head>
<body>
<div>
<form action="${path}/user/save.do" method="post">
	<input type="text" name="id" value="${user.id }" />
	<table border="1">
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="userName" value="${user.userName }" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="提交" /></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>