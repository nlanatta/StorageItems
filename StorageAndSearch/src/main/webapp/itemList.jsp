<%@include file="tagsHeader.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="header.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Show Items</title>
</head>
<%@include file="navHeader.jsp"%>
<div class="jumbotron">
	<div class="container">
		<h1>Check Storage Items</h1>
		<p>
		<p>
			<a class="btn btn-primary btn-lg" href="admin" role="button">Go
				to admin</a>
		</p>
	</div>
</div>

<div id="form" class="container">
	<spring:url value="/resources/core/images/" var="itemsImageUrl" />

	<div class="row">
		<c:forEach items="${model.items}" var="item">
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail">
					<img class="img-responsive" width="242" height="200" src="${itemsImageUrl}${item.image}" alt="${item.name}">
					<div class="caption">
						<h3>${item.name}</h3>
						<p>${item.description}</p>
						<p>
							<a href="edit?id=${item.id}" class="btn btn-default" role="button">Edit</a> 
							<a href="delete?id=${item.id}" class="btn btn-default" role="button">Delete</a>
						</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

	<hr>
	<footer>
		<p>&copy; Storage Items</p>
	</footer>
</div>

</html>