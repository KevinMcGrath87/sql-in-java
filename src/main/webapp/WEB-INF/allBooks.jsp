<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 

<table class = "table table-secondary">

    <c:forEach var="book" items= "${books}">
				<tr >
					<th><p><c:out value = "${book.getId()}"></c:out></p></th>
	            	<th><p><c:out value= "${book.getTitle()}"></c:out> </p></th>
	            	<th><p><c:out value= "${book.getDescription()}"></c:out></p></th>
	            	<th><p><c:out value= "${book.getNumberOfPages()}"></c:out></p></th>
            	</tr>
            </c:forEach>  
</table>


            
        <script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>