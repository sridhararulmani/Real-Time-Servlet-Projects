<%@page import="com.jsp.carProject.Car"%>
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
	Car car = (Car) request.getAttribute("existingCar");
	%>
	<h1>Update Car Data</h1>
	<form action="saveUpdateCar" method="post">
		<input type="number" name="carId" value="<%=car.getCarId()%>" readonly="true"> <br>
		<input type="text" name="carModel" value="<%=car.getCarModel()%>"><br>
		<input type="text" name="carBrand" value="<%=car.getCarBrand()%>"><br>
		<input type="number" name="carPrice" value="<%=car.getCarPirce()%>"><br>
		<input type="submit" value="Update">
	</form>
</body>
</html>