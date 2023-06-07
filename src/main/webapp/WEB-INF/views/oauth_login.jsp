<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Oauth2 Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />
</head>

<body>
<div class="container">
	<div class="col-sm-3 well">
		<h3>Login with:</h3>
		<div class="list-group">
<%--			<p th:each="url : ${urls}">--%>
<%--				<a th:text="${url.key}" th:href="${url.value}" class="list-group-item active">Client</a>--%>
<%--			</p>--%>
			<c:forEach items="${urls}" var="item">

				<a text="${item.value}" href="${item.value}" class="list-group-item active">Client</a>
			</c:forEach>
		</div>
	</div>
</div>
</body>
</html>