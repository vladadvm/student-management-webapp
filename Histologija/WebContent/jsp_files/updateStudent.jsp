<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Izmeni studenta</title>
<link 
	rel="stylesheet" 
	type="text/css"
	href="../css/style.css"
/>
</head>
<body>

	<h1>IZMENI STUDENTA</h1>
	
	<div class = "slikaProfesor">
		<p>Klik na sliku za vracanje nazad.</p>	
		<a href = "profesorPage.jsp"> <img src = "../images/download.jpg" alt = "profesor" /></a>
	</div>
	
	<form action = "../UpdateStudentController" method = "get">
	
				                       <input type = "hidden" name = "idStudent" value = "${param.idOdStudenta}">
			IME			               <input type = "text" name = "ime"><br><br>
			PREZIME		               <input type = "text" name = "prezime"><br><br>
			BROJ INDEKSA               <input type = "text" name = "brojIndeksa"><br><br> 		
			GRUPA		               <input type = "text" name = "grupa"><br><br>
			POL                        <input type="radio" id="male" name="pol" value="M">
						  			    	<label for="male">M</label>
						  			   <input type="radio" id="female"name="pol" value="Z">
						  			   		<label for="male">Z</label><br><br>
			ZABELESKE                  <input type = "text" name = "zabeleske"><br><br> 
			OCENA			           <input type = "text" name = "ocena"><br><br>
						               <input type = "submit" value = "IZMENI">
	
	
	</form>
	

</body>
</html>