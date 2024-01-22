<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add New Food Recipe</h1>
	<form action="AddNewFoodRecipe" method="post">
		<div class="Inputs">
			<input type="number" placeholder="Enter the Food Code"name="foodCode">
			<input type="text"placeholder="Enter the Food Name" name="foodName"> 
			<input type="number" placeholder="Enter the Food Price" name="foodPrice">
		</div>
		<div class="Button">
			<input type="submit" value="Add Food">
		</div>
	</form>
</body>
</html>