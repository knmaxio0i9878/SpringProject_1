<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1> Product </h1>
	
	<form action="/saveproduct" method="post" enctype="multipart/form-data"> 	
	
		ProductName : <input type="text" name="productName"><br><br>
		Category : <input type="text" name="category"><br><br>
		Quantity : <input type="text" name="qty"><br><br>
		Price : <input type="text" name="price"><br><br>
		Image : <input type="file" name="masterImage"><br><br>
		
		<input type="submit" value="Submit">
	
	</form>

</body>
</html>