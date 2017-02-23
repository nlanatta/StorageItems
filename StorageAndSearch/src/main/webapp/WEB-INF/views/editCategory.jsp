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
<title>Edit Category</title>
</head>
<jsp:include page="header.jsp" />

<div class="jumbotron">
	<div class="container">
		<h1>Check Storage Categories</h1>
		<p>
		<p>
			<a class="btn btn-primary btn-lg" href="catList" role="button">Go
				to categories</a>
		</p>
	</div>
</div>

<c:if test="${model.result}">
	<spring:url value="<script>resetElements('form');</script>"
		var="aditionalStylesValues" />
</c:if>

<div id="form" class="container" ${aditionalStylesValues}>
	<spring:url value="/categories" var="categoriesActionUrl" />
	<spring:url value="/resources/core/images/" var="categoriesImageUrl" />
	
	<form:form action="${categoriesActionUrl}" method="post" modelAttribute="admin" enctype="multipart/form-data">
		<div class="form-group">
			<label>Name</label>
			<form:input path="name" type="text" class="form-control" id="name" placeholder="${model.category.name}" />
		</div>
		<div class="form-group">
			<label>Description</label>
			<form:textarea path="description" id="description" class="form-control" rows="4" cols="50" 
				placeholder="${model.category.description}"/>
		</div>
		<div class="form-group">
			<label>Currently image</label>
			<img class="thumbnail" width="242" height="200" src="${categoriesImageUrl}${model.category.image}" alt="${model.category.name}">					
			<label>Attach file</label>
			<form:input path="image" id="image" type="file" />
			<p class="help-block">Chose an image for the category</p>
		</div>
		<form:input path="id" type="hidden" value="${model.category.id}" />
		<button type="submit" class="btn btn-default">Send</button>
	</form:form>

	<hr>
	<footer>
		<p>&copy; Storage Categories</p>
	</footer>
</div>
${aditionalStylesValues}

<spring:url value="<script>resetElements('result');</script>"
	var="aditionalStylesValues" />
<c:if test="${model.result}">
	<spring:url value="" var="aditionalStylesValues" />
</c:if>

<div id="result" class="container">
	<spring:url value="/categories" var="itemsActionUrl" />

	<div class="page-header">
		<h1>
			Category call ${model.category.name}<small> Was succesfully edited.</small>
		</h1>
	</div>

	<footer>
		<p>&copy; Storage Categories</p>
	</footer>
</div>
${aditionalStylesValues}

</html>