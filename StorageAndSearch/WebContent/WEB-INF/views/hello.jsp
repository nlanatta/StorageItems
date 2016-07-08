<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<title>Insert title here</title>
</head>
<nav class="navbar navbar-inverse navbar-fixed-top">
<div class="container">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">Storage Items</a>
	</div>
</div>
</nav>

<div class="jumbotron">
	<div class="container">
		<h1>${title}</h1>
		<p>
		<p>
			<a class="btn btn-primary btn-lg" href="#" role="button">Learn
				more</a>
		</p>
	</div>
</div>

<div class="container">

	<form role="form">
		<div class="form-group">
			<label for="ejemplo_email_1">Email</label> <input type="email"
				class="form-control" id="ejemplo_email_1"
				placeholder="Introduce tu email">
		</div>
		<div class="form-group">
			<label for="ejemplo_password_1">Contraseña</label> <input
				type="password" class="form-control" id="ejemplo_password_1"
				placeholder="Contraseña">
		</div>
		<div class="form-group">
			<label for="ejemplo_archivo_1">Adjuntar un archivo</label> <input
				type="file" id="ejemplo_archivo_1">
			<p class="help-block">Ejemplo de texto de ayuda.</p>
		</div>
		<div class="checkbox">
			<label> <input type="checkbox"> Activa esta casilla
			</label>
		</div>
		<button type="submit" class="btn btn-default">Enviar</button>
	</form>


	<hr>
	<footer>
	<p>&copy; Storage Items</p>
	</footer>
</div>

<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />

<script src="${bootstrapJs}"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</html>