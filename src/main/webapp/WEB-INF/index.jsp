<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Title:<c:out value ="${book.getTitle()}"></c:out></h1>
<h1>Description:<c:out value = "${book.getDescription()}"></c:out></h1>
<h1>Number of Pages:<c:out value = "${book.getNumberOfPages()}"></c:out></h1>

</body>
</html>