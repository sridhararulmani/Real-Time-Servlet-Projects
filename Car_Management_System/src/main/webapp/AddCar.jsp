<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="AddCarStyles.css">
</head>
<body>
	<h1>Enter Car Details</h1>
	<form action="AddNewCar" method="post">
		<section class="inputs">
			<input type="number" placeholder="Enter the CarId" name="carId">
			<input type="text" placeholder="Enter the CarModel" name="carModel">
			<input type="text" placeholder="Enter the CarBand" name="carBrand">
			<input type="number" placeholder="Enter the CarPrice" name="carPrice">
		</section>
		<section class="button">
			<input type="submit" value="Add">
		</section>
	</form>
</body>
</html>