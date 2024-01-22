<%@page import="com.jsp.HotelProject.Food"%>
<%@page import="java.util.List"%>
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
	List<Food> foods = (List) request.getAttribute("foodList");
	%>
	<table border=" ">
		<thead>
			<tr>
				<th>Food Code</th>
				<th>Food Name</th>
				<th>Food Price</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<%
		for (Food food : foods) {
		%>
		<tbody>
			<tr>
				<td><%=food.getFoodCode()%></td>
				<td><%=food.getFoodName()%></td>
				<td><%=food.getFoodPrice()%></td>
				<td><a href="update?foodCode=<%=food.getFoodCode()%>">Update</a></td>
				<td><a href="">Delete</a></td>
			</tr>
		</tbody>
		<%
		}
		%>
	</table>
	<a href="index.jsp">Back To Welcome Page</a>
</body>
</html>