<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>


<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script> 

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




<!-- this is going to display n injas and links to enter and save ninjas and dojos together -->

<div class = "container">
	<table>
		<tr >
			<th>Name</th>
			<th>Last Name</th>
			<th>Ninja's</th>
		</tr>
	<c:forEach var = "dojo" items = "${dojos}">
		<tr>
			<td>${dojo.getName()}</td>
			<td>${dojo.getLocation()}</td>

			<td><c:forEach var = "ninja" items = "${dojo.ninjas}">
				<c:out value = "${ninja.getFirstName()}"></c:out>
				</c:forEach>
			</td> 
		</tr>
	</c:forEach>
	</table>
	<a href = "/ninja">Add a ninja</a>
	<a href = "/dojo">Add a dojo</a>

</div>



<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>