<%@include file="tagsHeader.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="header.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Categories</title>
</head>
<%@include file="navHeader.jsp"%>

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