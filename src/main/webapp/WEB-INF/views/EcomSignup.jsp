<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>

	
	
	<div class="container-fluid">
	<form action="/ecomsignup" method="post" enctype="multipart/form-data">
	
	<div class="row">
	
		<div class="col-md-3"></div>
		<div class="col-md-6">
	<h1>Ecommerce Login Page</h1>
			FirstName : <input type="text" name="firstname" value="${ecomBean.firstname}" class="form-control">
			Email :	<input type="text" name="email"  class="form-control"><br>
			Password :	<input type="password" name="password"  class="form-control"><br>
			Profile Image : <input type="file" name="profileImage" class="form-control"><br>
			<input type="Submit" value="SUBMIT" class="btn btn-success">
		</div>
		
	</div>
	 </form>
	 
	 </div>


</body>
</html>