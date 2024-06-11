<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Box Cricket Reg</title>
</head>
<body>


	<h1>Box Cricket Registration</h1>
	<form action="savereg" method="post">
	
	
		<span style="color:red">*</span>Name : <input type="text" name="name" value="${nameValue}"><br>
		<span style="color:red">${nameError}</span>
		<br><br>
		
		
		<span style="color:red">*</span>Playing type:<br>
		Batsman:<input type="radio" name="playertype" value="Batsman"   ${playerValue!=null && playerValue.equals("Batsman")?"checked":"" }>
		Bowler:<input type="radio" name="playertype" value="Bowler" ${playerValue!=null && playerValue.equals("Bowler")?"checked":"" }>
		All-rounder:<input type="radio" name="playertype" value="All-rounder"><br ${playerValue!=null && playerValue.equals("All-rounder")?"checked":"" }>
		<span style="color:red">${playerError}</span>
		<br><br>
		
		<span style="color:red">*</span>Food Preference :<br>
		<select name="foodtype">
			<option value="-1">-Select Option-</option>
			<option value="Normal"  ${foodValue!=null && foodValue.equals("Normal")?"selected":"" }>Normal</option>
			<option value="Jain" ${foodValue!=null && foodValue.equals("Jain")?"selected":"" }>Jain</option>
		</select><br>
		<span style="color:red">${foodError}</span>
		<br><br>
		
		
		<span style="color:red">*</span>Cold-Drink :<br>
		Red-Bull:<input type="checkbox" name="colddrink" value="RedBull" ${drinkValue!=null && drinkValue.contains("RedBull")?"checked":"" }>
		Mountain-Dew:<input type="checkbox" name="colddrink" value="MountainDew" ${drinkValue!=null && drinkValue.contains("MountainDew")?"checked":"" }>
		Thumpsup:<input type="checkbox" name="colddrink" value="Thumpsup" ${drinkValue!=null && drinkValue.contains("Thumpsup")?"checked":"" } ><br>
		<span style="color:red">${drinkError}</span>
		<br><br>
		
		
		<input type="submit" value="Register">
	
	</form>

</body>
</html>