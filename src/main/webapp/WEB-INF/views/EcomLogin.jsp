<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

	
	<h1>Ecommerce Login Page</h1>
	<form action="/ecomlogin" method="post">
	
	
	
		FirstName : <input type="text" name="firstname" value="${ecomBean.firstname}"><br>
		Email :	<input type="text" name="email" ><br>
		Password :	<input type="password" name="password" ><br>
		<input type="Submit" value="SUBMIT" >
				
	 </form>


</body>
</html>