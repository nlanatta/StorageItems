<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />
<spring:url value="/resources/core/js/app.js" var="appJs" />
<script src="${bootstrapJs}"></script>
<script src="${appJs}"></script>
<title>Admin</title>
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
			
			
			<div class="btn-group bootstrap-select show-tick">
				<button type="button" class="btn dropdown-toggle btn-default bs-placeholder" data-toggle="dropdown" role="button" title="Nothing selected" aria-expanded="false">
					<span class="filter-option pull-left">Nothing selected</span>&nbsp;
					<span class="bs-caret">
						<span class="caret"></span>
					</span>
				</button>
				<div class="dropdown-menu open" role="combobox" style="max-height: 216px; overflow: hidden; min-height: 0px;">
					<ul class="dropdown-menu inner" role="listbox" aria-expanded="false" style="max-height: 204px; overflow-y: auto; min-height: 0px;">
						<li data-original-index="0" class="">
							<a tabindex="0" class="" data-tokens="null" role="option" aria-disabled="false" aria-selected="false">
								<span class="text">Mustard</span>
								<span class="glyphicon glyphicon-ok check-mark"></span>
							</a>
						</li>
						<li data-original-index="1">
							<a tabindex="0" class="" data-tokens="null" role="option" aria-disabled="false" aria-selected="false">
								<span class="text">Ketchup</span>
								<span class="glyphicon glyphicon-ok check-mark"></span>
							</a>
						</li>
						<li data-original-index="2" class="">
							<a tabindex="0" class="" data-tokens="null" role="option" aria-disabled="false" aria-selected="false">
								<span class="text">Relish</span>
								<span class="glyphicon glyphicon-ok check-mark"></span>
							</a>
						</li>
					</ul>
				</div>
				<select class="selectpicker" multiple="" tabindex="-98">
				    <c:forEach items="${model.categories}" var="category">
						  <option>{category.name}</option>
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