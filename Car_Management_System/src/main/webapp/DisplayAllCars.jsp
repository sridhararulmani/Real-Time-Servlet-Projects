<%@page import="com.jsp.carProject.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="DisplayStyles.css">
</head>
<body>
	<%
	List<Car> cars = (List) request.getAttribute("carList");
	%>
	<table border=" ">
		<tr>
			<th class="heading">CarId</th>
			<th class="heading">CarModel</th>
			<th class="heading">CarBrand</th>
			<th class="heading">CarPrice</th>
			<th class="heading">Update</th>
			<th class="heading">Delete</th>
		</tr>
		<%
		for (Car car : cars) {
		%>
		<tr>
			<td class="data"><%=car.getCarId()%></td>
			<td class="data"><%=car.getCarModel()%></td>
			<td class="data"><%=car.getCarBrand()%></td>
			<td class="data"><%=car.getCarPirce()%></td>
			<td><a href="UpdateCar?carId=<%=car.getCarId()%>">Update</a></td>
			<td><a href="DeleteCar?carId=<%=car.getCarId()%>">Delete</a></td>
		</tr>
		<%
		}
		%>
	</table> <br>
	<a href="index.jsp">Back to Welcom Page</a>
</body>
</html>