<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css"/>
<title>Insert title here</title>
</head>
<body>
		
		HEMOS LLEGADO AL FORMULARIO DE INSERTAR
		</br>
		<form:form action="insertarCliente" modelAttribute="cliente" method="POST">
			<table>
				<tr>
					<td>NOMBRE:</td>
					<td><form:input path="nombre"/></td>
				</tr>
				<tr>
					<td>APELLIDO:</td>
					<td><form:input path="apellido"/></td>
				</tr>
				<tr>
					<td>EMAIL:</td>
					<td><form:input path="email"/></td>
				</tr>
				
				<tr>
					<td colspan="2"><input type="submit" value="Insertar"></td>
				</tr>
			</table>
		</form:form>
		
</body>
</html>