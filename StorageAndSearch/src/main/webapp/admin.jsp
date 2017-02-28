<%@include file="tagsHeader.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="header.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin Items</title>
</head>
<%@include file="navHeader.jsp"%>

<div class="jumbotron">
	<div class="container">
		<h1>Check Storage Items</h1>
		<p>
		<p>
			<a class="btn btn-primary btn-lg" href="itemList" role="button">Go to items</a>
		</p>
	</div>
</div>

<c:if test="${model.result}">
	<spring:url value="<script>resetElements('form');</script>" var="aditionalStylesValues"/>
</c:if>

<div id="form" class="container" ${aditionalStylesValues}>
	<spring:url value="/items" var="itemsActionUrl" />

	<form:form action="${itemsActionUrl}" method="post" modelAttribute="admin" enctype="multipart/form-data">
			<div class="form-group">
				<label>Name</label> 
				<form:input path="name" type="text" class="form-control" id="name" placeholder="Name" />
			</div>
			<div class="form-group">
				<label>Description</label>
				<form:textarea path="description" id="description" class="form-control"  rows="4" cols="50" placeholder="Set item description" />			
			</div>
			
			<div class="form-group">
				<!-- Build your select: -->
				<select name="categories" path="categories" id="multiselect" multiple="categories">
					<c:forEach items="${model.categories}" var="category">
					    <option value="${category.id}">${category.name}</option>
					</c:forEach>
				</select>
			</div>

			<div class="form-group">
				<label>Attach file</label> 
				<form:input path="image" id="image" type="file" />
				<p class="help-block">Chose an image for the item</p>
			</div>
		<button type="submit" class="btn btn-default">Send</button>
	</form:form>

	<hr>
	<footer>
		<p>&copy; Storage Items</p>
	</footer>
</div>
${aditionalStylesValues}

<spring:url value="<script>resetElements('result');</script>" var="aditionalStylesValues"/>
<c:if test="${model.result}">
	<spring:url value="" var="aditionalStylesValues"/>
</c:if>

<div id="result" class="container" >
	<spring:url value="/items" var="itemsActionUrl" />

	<div class="page-header">
	    <h1>Item call ${model.item.name}<small> Was succesfully added.</small></h1>
	</div>

	<footer>
		<p>&copy; Storage Items</p>
	</footer>
</div>
${aditionalStylesValues}

</html>