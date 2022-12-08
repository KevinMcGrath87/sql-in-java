<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class = "container">
	<h1>Edit Eine BURgER!</h1>
		<form:form action = "/update/${burger.getId()}" method = "POST" modelAttribute = "burger" class = "form" >
		<input type = "hidden" name = "_method" value = "put">
			<form:input type = "text" path ="name" value = "${burger.getName()}"/>
			<form:errors path = "name" class = "text-danger"/>
			<form:input type = "text" path = "description" value = "${burger.getDescription()}"/>
			<form:errors path ="description" class = "text-danger"/>
			<form:input type = "number" path = "price" value = "${burger.getPrice()}"/>
			<form:errors path = "price" class = "text-danger"/>
			<input type = "submit" value = "submit">
	</form:form>
</div>


<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>