<jsp:include page="tagsHeader.jsp" />
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="header.jsp" />
<title>Delete Items</title>
</head>
<jsp:include page="navHeader.jsp" />
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