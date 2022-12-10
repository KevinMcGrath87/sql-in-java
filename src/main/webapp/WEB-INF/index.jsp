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
<div class = "container">
	<h1>Expense List</h1>
	<table class = "table">
		<tr>
			<th>id</th>
			<th>expense name</th>
			<th>description</th>
			<th>amount</th>
			<th>vendor</th>
			<th>actions<th>
		</tr>
		<c:forEach var = "expense" items = "${expenses}">
			<tr>
				<td><c:out value = "${expense.getId()}"></c:out></td>
				<td><c:out value = "${expense.getExpense()}"></c:out></td>
				<td><c:out value = "${expense.getDescription()}"></c:out></td>
				<td><c:out value = "${expense.getAmount()}"></c:out></td>
				<td><c:out value = "${expense.getVendor()}"></c:out></td>
				<td>
					<form:form action = "edit/${expense.getId()}" method = "get">
						<input type = "submit" value = "edit">
					</form:form>
					<form:form action = "/delete/${expense.getId()}" method = "post">
						<input type = "hidden" name = "_method" value = "delete">
						<input type = "submit" value = "delete">
					</form:form>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<h1>Add an Expense</h1>
		<form:form action = "/create" method = "POST" modelAttribute = "newExpense" class = "form" >
			<form:label path="expense">Expense</form:label>
			<form:input type = "text" path ="expense"/>
			<form:errors path = "expense" class = "text-danger"/>
			<form:label path ="description">Expense Description</form:label>
			<form:input type = "text" path = "description"/>
			<form:errors path ="description" class = "text-danger"/>
			<form:label path ="vendor">Vendor</form:label>
			<form:input type = "text" path = "vendor"/>
			<form:errors path ="vendor" class = "text-danger"/>
			<form:label path ="amount">Amount</form:label>
			<form:input type = "number" step = ".01" path = "amount"/>
			<form:errors path = "amount" class = "text-danger"/>
			<input type = "submit" value = "submit">
	</form:form>
	
</div>



<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>