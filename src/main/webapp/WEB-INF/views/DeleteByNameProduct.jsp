<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h3> Enter a Name of Product to Delete</h3>

		<form action="/name" method="post">
			Delete By Name : <input type="text" name="productName">
			<br>
			<input type="submit" value="Submit">		
		</form>

</body>
</html>