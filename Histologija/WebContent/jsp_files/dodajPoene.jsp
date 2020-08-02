<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodavanje poena</title>
<link 
	rel="stylesheet" 
	type="text/css"
	href="../css/style.css"
/>
</head>
<body>
	<h1>
		DODAVANJE ISPITA
	</h1>
	
	<div class = "slikaProfesor">
		<p>Klik na sliku za vracanje nazad.</p>
		<a href = "profesorPage.jsp">
			<img src = "../images/download.jpg" alt = "profesor" />
		</a>
	</div>
	
	<div>
		<form action = "../DodajPoeneController" method = "get">
		
		                          <input type = "hidden" name = "idStudent" value = "${param.idOdStudenta}">
			POENI NA I KOL        <input type = "text" name = "poeniNaIKol"><br><br>
			POENI NA II KOL   	  <input type = "text" name = "poeniNaIIKol"><br><br>
			POENI NA III KOL      <input type = "text" name = "poeniNaIIIKol"><br><br>
			POENI SA VEZBI		  <input type = "text" name = "poeniSaVezbi"><br><br>      
			POENI SA PREDAVANJA   <input type = "text" name = "poeniSaPredavanja"><br><br>  
				                  <input type = "submit" value = "Dodaj Poene">
		</form>
	</div>
</body>
</html>