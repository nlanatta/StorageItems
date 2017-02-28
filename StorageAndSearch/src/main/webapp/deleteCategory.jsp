<%@include file="tagsHeader.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="header.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Delete Cataloge</title>
</head>
<%@include file="navHeader.jsp"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Storage Categories</a>
		</div>
	</div>
</nav>

<div class="jumbotron">
	<div class="container">
		<h1>Check Storage Categories</h1>
		<p>
		<p>
			<a class="btn btn-primary btn-lg" href="catList" role="button">Go to Categories</a>
		</p>
	</div>
</div>

<div id="result" class="container" >
	<div class="page-header">
	    <h1>Category call ${model.category.name}<small> Was succesfully deleted.</small></h1>
	</div>

	<footer>
		<p>&copy; Storage Categories</p>
	</footer>
</div>

</html>