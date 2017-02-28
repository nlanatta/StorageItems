<jsp:include page="tagsHeader.jsp" />
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="header.jsp" />
<title>Edit Item</title>
</head>
<jsp:include page="navHeader.jsp" />

<div class="jumbotron">
	<div class="container">
		<h1>Check Storage Items</h1>
		<p>
		<p>
			<a class="btn btn-primary btn-lg" href="itemList" role="button">Go
				to items</a>
		</p>
	</div>
</div>

<c:if test="${model.result}">
	<spring:url value="<script>resetElements('form');</script>"
		var="aditionalStylesValues" />
</c:if>

<div id="form" class="container" ${aditionalStylesValues}>
	<spring:url value="/items" var="itemsActionUrl" />
	<spring:url value="/resources/core/images/" var="itemsImageUrl" />
	
	<form:form action="${itemsActionUrl}" method="post" modelAttribute="admin" enctype="multipart/form-data">
		<div class="form-group">
			<label>Name</label>
			<form:input path="name" type="text" class="form-control" id="name" placeholder="${model.item.name}" />
		</div>
		<div class="form-group">
			<label>Description</label>
			<form:textarea path="description" id="description" class="form-control" rows="4" cols="50" 
				placeholder="${model.item.description}"/>
		</div>
		<div class="form-group">
			<label>Currently image</label>
			<img class="thumbnail" width="242" height="200" src="${itemsImageUrl}${model.item.image}" alt="${model.item.name}">					
			<label>Attach file</label>
			<form:input path="image" id="image" type="file" />
			<p class="help-block">Chose an image for the item</p>
		</div>
		<form:input path="id" type="hidden" value="${model.item.id}" />
		<button type="submit" class="btn btn-default">Send</button>
	</form:form>

	<hr>
	<footer>
		<p>&copy; Storage Items</p>
	</footer>
</div>
${aditionalStylesValues}

<spring:url value="<script>resetElements('result');</script>"
	var="aditionalStylesValues" />
<c:if test="${model.result}">
	<spring:url value="" var="aditionalStylesValues" />
</c:if>

<div id="result" class="container">
	<spring:url value="/items" var="itemsActionUrl" />

	<div class="page-header">
		<h1>
			Item call ${model.item.name}<small> Was succesfully edited.</small>
		</h1>
	</div>

	<footer>
		<p>&copy; Storage Items</p>
	</footer>
</div>
${aditionalStylesValues}

</html>