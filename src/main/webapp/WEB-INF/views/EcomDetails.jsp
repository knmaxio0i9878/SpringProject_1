<%@page import="java.util.List"%>
<%@page import="com.bean.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Product Details..</h1>
	
	<a href="/getproduct">Add A Product</a><br><br>
	<a href="/name">Delete by Name Product</a><br><br>
		
	<%List<ProductBean> product = (List<ProductBean>) request.getAttribute("product"); %>
	
	<table border=1>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Action</th>
		</tr>
		<%
			for(ProductBean p : product){
				out.println("<tr>");
				
					out.println("<td>"+p.getProductId()+"</td>");
					out.println("<td>"+p.getProductName()+"</td>");
					out.println("<td><a href='delete?productId="+p.getProductId()+"'> Delete</a> | <a href='getdetails?productId="+p.getProductId()+"'> Details </a></td>");
				
				out.println("</tr>");
			}
		%>
	</table>
	

</body>
</html>