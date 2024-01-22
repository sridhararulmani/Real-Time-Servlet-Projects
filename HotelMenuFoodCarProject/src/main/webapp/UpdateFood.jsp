<%@page import="com.jsp.HotelProject.Food"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Food food = (Food) request.getAttribute("existingFood");
	%>
	<form action="UpdateDetails" method="post">
		<div class="Input">
			<input type="number" value="<%=food.getFoodCode()%>" readonly="true">
			<input type="text" value="<%=food.getFoodName()%>"> 
			<input type="number" value="<%=food.getFoodPrice()%>">
		</div>
		<div class="Button">
			<input type="submit" value="Update Food">
		</div>
	</form>
</body>
</html>