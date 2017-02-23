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
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<spring:url value="/resources/core/js/bootstrap.min.js"
	var="bootstrapJs" />
<spring:url value="/resources/core/js/app.js" var="appJs" />
<script src="${bootstrapJs}"></script>
<script src="${appJs}"></script>
<title>Category List</title>
</head>
<jsp:include page="header.jsp" />

<div class="jumbotron">
	<div class="container">
		<h1>Check Storage Categories</h1>
		<p>
		<p>
			<a class="btn btn-primary btn-lg" href="admin" role="button">Go
				to admin</a>
		</p>
	</div>
</div>

<div id="form" class="container">
	<spring:url value="/resources/core/images/" var="catsImageUrl" />

	<div class="row">
		<c:forEach items="${model.categories}" var="category">
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail">
					<img class="img-responsive" width="242" height="200" src="${catsImageUrl}${category.image}" alt="${category.name}">
					<div class="caption">
						<h3>${category.name}</h3>
						<p>${category.description}</p>
						<p>
							<a href="editCategory?id=${category.id}" class="btn btn-default" role="button">Edit</a> 
							<a href="deleteCategory?id=${category.id}" class="btn btn-default" role="button">Delete</a>
						</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

	<hr>
	<footer>
		<p>&copy; Storage Categories</p>
	</footer>
</div>

</html>