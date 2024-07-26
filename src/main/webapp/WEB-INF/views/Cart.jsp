<%@page
	import="ch.qos.logback.core.recovery.ResilientSyslogOutputStream"%>
<%@page import="com.bean.ProductBean"%>
<%@page import="com.bean.EcomCartBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
	integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	padding: 20px;
}

.table-container {
	width: 100%;
	max-width: 800px;
	margin: 0 auto;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	overflow: hidden;
}

table {
	width: 100%;
	border-collapse: collapse;
}

table th, table td {
	padding: 12px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

table th {
	background-color: #f2f2f2;
}

table td {
	background-color: #fff;
}

.product-image {
	width: 100px;
}

.product-name {
	font-weight: bold;
}

.product-price {
	color: #007bff;
}

.action-button {
	background-color: #007bff;
	color: #fff;
	border: none;
	padding: 8px 12px;
	border-radius: 4px;
	cursor: pointer;
}

.action-button:hover {
	background-color: #0056b3;
}
.product-price{
	text-color:"black"
}

</style>
</head>
<body>
	<!-- <h1 style="text-align: center">Your Cart</h1> -->

	<%
	List<ProductBean> product = (List<ProductBean>) request.getAttribute("product");
	Float total = 0.0f;
	
	%>
	<%-- <%
	for (ProductBean p : product) {
	%>
	 --%>
	 <a href="/">Log out your Session</a>
	<div class="table-container">
		<table>
			<thead>
				<tr>
					<th>Product Image</th>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<tr>

					<%
					for (ProductBean p : product) {
					%>

					<%
					out.println("<td><img src='" + p.getProductimgpath() + "' alt='Product 1' class='product-image'></td>");
					%>
					<%
					out.println("<td class='product-name'>" + p.getProductName() + "</td>");
					%>
					<%
					out.println("<td class='product-price' text-light>" + p.getPrice() + "</td>");
					total = total + p.getPrice();
					%>
					<td>
					
					<button class="action-button">
						<a href="removecart?productId=<%=p.getProductId()%>">
							<i class="fa-solid fa-trash text-light sp-1"></i>
						</a>
						</button>
					
					
						<button class="action-button">
							<a href="viewproduct?productId=<%=p.getProductId()%>">
								<i class="fa-solid fa-eye text-light" ></i>
							</a>
						</button>
					</td>
				</tr>
				<%
				}
				%>
				<tr>
					<td><h3><strong>&nbsp;&nbsp;Total                    </strong></h3></td>
					<td></td>
					<td></td>
					<td><strong><%=total %></strong></td>
				</tr>
				<!-- Add more rows as needed -->
			</tbody>
		</table>
	</div>





	


</body>
</html>