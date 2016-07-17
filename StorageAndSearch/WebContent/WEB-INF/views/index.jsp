<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />
<spring:url value="/resources/core/js/app.js" var="appJs" />
<script src="${bootstrapJs}"></script>
<script src="${appJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<title>Admin Panel Items</title>
</head>
<jsp:include page="header.jsp" />

<div class="jumbotron">
	<div class="container">
		<h1>Check Storage Items</h1>
		<p>
		<p>
			<a class="btn btn-primary btn-lg" href="itemList" role="button">Go to items</a>
		</p>
	</div>
</div>

<div class="jumbotron">
	<div class="container">
		<h1>Add Items</h1>
		<p>
		<p>
			<a class="btn btn-primary btn-lg" href="admin" role="button">Go to admin</a>
		</p>
	</div>
</div>


</html>