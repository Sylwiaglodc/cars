<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="editCarServlet"  method="post">
			Make: <input type ="text" name="make" value="${itemToEdit.make}">
			Model: <input type ="text" name="model" value="${itemToEdit.model}">
			Liters: <input type ="text" name="liters" value="${itemToEdit.liters}">
			Cylinders: <input type ="text" name="cylinders" value="${itemToEdit.cylinders}">
			Turbo: <input type ="text" name="turbo" value="${itemToEdit.turbo}">
			<input type ="hidden" name ="id" value="${itemToEdit.id}">
			<input type ="submit" value="Save Edited Car">
		</form>
	</body>
</html>