<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</head>
<body>

<div class = "container">
	<h1>Burger List</h1>
	<table class = "table">
		<tr>
			<th>id</th>
			<th>burger name</th>
			<th>description</th>
			<th>price</th>
		</tr>
		<c:forEach var = "burger" items = "${burgers}" >
			<tr>
				<td><c:out value = "${burger.getId()}"></c:out></td>
				<td><c:out value = "${burger.getName()}"></c:out></td>
				<td><c:out value = "${burger.getDescription()}"></c:out></td>
				<td><c:out value = "${burger.getPrice()}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	
	<h1>Add Eine BURgER!</h1>
		<form:form action = "/create" method = "POST" modelAttribute = "burger" class = "form" >
			<form:input type = "text" path ="name"/>
			<form:errors path = "name" class = "text-danger"/>
			<form:input type = "text" path = "description"/>
			<form:errors path ="description" class = "text-danger"/>
			<form:input type = "number" path = "price"/>
			<form:errors path = "price" class = "text-danger"/>
			<input type = "submit" value = "submit">
	</form:form>
	
</div>




        <script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>