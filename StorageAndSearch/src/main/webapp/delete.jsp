<%@include file="tagsHeader.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="header.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Delete Item</title>
</head>
<%@include file="navHeader.jsp"%>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Storage Items</a>
		</div>
	</div>
</nav>

<div class="jumbotron">
	<div class="container">
		<h1>Check Storage Items</h1>
		<p>
		<p>
			<a class="btn btn-primary btn-lg" href="itemList" role="button">Go to items</a>
		</p>
	</div>
</div>

<div id="result" class="container" >
	<div class="page-header">
	    <h1>Item call ${model.item.name}<small> Was succesfully deleted.</small></h1>
	</div>

	<footer>
		<p>&copy; Storage Items</p>
	</footer>
</div>

</html>