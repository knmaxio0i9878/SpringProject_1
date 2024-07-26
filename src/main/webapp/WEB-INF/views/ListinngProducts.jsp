<%@page import="com.bean.ProductBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
	integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<%-- <link href="<link href="" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"> --%>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>

<title>Insert title here</title>
<style>
/* 	.icon-hover:hover {
  border-color: success !important;
  background-color: success !important;
}

.icon-hover:hover i {
  border-color: green  !important;
} */
body {
	min-height: 100vh;
	background: #fafafa;
}

.social-link {
	width: 30px;
	height: 30px;
	border: 1px solid #ddd;
	display: flex;
	align-items: center;
	justify-content: center;
	color: #666;
	border-radius: 50%;
	transition: all 0.3s;
	font-size: 0.9rem;
}

.social-link:hover, .social-link:focus {
	background: #ddd;
	text-decoration: none;
	color: #555;
}

.progress {
	height: 10px;
}

.options {
	display: flex;
	justify-content: center;
}
.a1{
	color:aliceblue;
}
.header {
    background-color: #333;
    color: #fff;
    padding: 15px 20px;
    text-align: center;
  }
  .search-container {
    display: flex;
    justify-content: center;
    margin-top: 10px;
  }
  .search-container input[type=text] {
    padding: 10px;
    width: 300px; /* Adjust width as needed */
    border: 1px solid #ccc;
    border-radius: 4px 0 0 4px;
    font-size: 16px;
  }
  .search-container button {
    padding: 10px 20px;
    background-color: #4CAF50;
    color: white;
    border: 1px solid #4CAF50;
    border-radius: 0 4px 4px 0;
    cursor: pointer;
    font-size: 16px;
  }
  .search-container button:hover {
    background-color: #45a049;
    border-color: #45a049;
  }
</style>
<script>
  document.getElementById('search-form').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent form submission
    let query = document.getElementById('search-input').value.trim();
    if (query) {
      // Perform search functionality (e.g., navigate to search results page)
      alert('Performing search for: ' + query);
      // Here you can implement further actions like fetching search results
    } else {
      alert('Please enter a search query.');
    }
  });
</script>

</head>
<body>
	<%
	List<ProductBean> product = (List<ProductBean>) request.getAttribute("product");
	%>
	<div class="header">
		<h1></h1>
		<div class="search-container">
			<input type="text" placeholder="Search...">
			<button type="submit">Search</button>
		</div>
	</div>
	<div class="container my-5">
		<div class="row pb-5 mb-4">
			<%
			for (ProductBean p : product) {
			%>
			<%-- <% out.println(p.getProductimgpath()); %> --%>
			<div class="col-lg-3 col-md-6 col-sm-6 d-flex">
				<div class="card w-100 my-2 shadow-2-strong">
					   <%out.println("<img src='"+p.getProductimgpath()+"' class='card-img-top' style='aspect-ratio: 1/1' />");
					   
					   %>   
					 <!-- <img src="productimage\iphone 13.jpeg" class='card-img-top'>  -->
					 
					<div class="card-body d-flex flex-column">
						<%
						out.println("<h5 class='card-title'>" + p.getProductName() + "," + p.getCategory() + "</h5>");
						%>
						<%
						out.println("<p class='card-text'> <i class='fa fa-inr'></i> &nbsp;" + p.getPrice() + "</p>");
						%>

						<div  class="option">
							<a href="addtocart?productId=<%=p.getProductId()%>" class="btn border px-2 pt-2 icon-hover" style="background-color: green"><i class="fas fa-solid fa-lg fa-cart-shopping text-light px-1"></i>
							<a href="#!" class="btn border px-2 pt-2 icon-hover" style="background-color: green"><i class="fas fa-solid fa-heart fa-lg text-light px-1" style="color: white"></i></a> 
							<a href="#!" class="btn border px-2 pt-2 icon-hover" style="background-color: green"><i	class="fas fa-solid fa-lg px-1  fa-plus text-light" style=""></i> </i></a>
							<a href="viewproduct?productId=<%=p.getProductId()%>" class="btn border px-2 pt-2 icon-hover" style="background-color: green"><i class="fa-regular fa-eye text-light px-1"  ></i></a>
						</div>

					</div>
				</div>
			</div>
			<%
			}
			%>
		</div>
	</div>
	
	<div style="text-align:center">
		<Button class="btn btn-success"><a href="/yourcart" style="text-decoration:none" class="a1">View Cart <i class="fas fa-solid fa-lg fa-cart-shopping text-light px-1"></i></a></Button>
	</div>
	<br/>


</body>
</html>