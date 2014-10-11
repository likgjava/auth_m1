<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/view/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/view/common/head.jsp" %>
<title>用户列表</title>
</head>
<body>
<div>
	<a href="${path }/user/toUserForm.do">新增用户</a>
	<table border="1">
		<c:forEach var="user" items="${userList}">
		<tr>
			<td>${user.id }</td>
			<td>${user.userName }</td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>