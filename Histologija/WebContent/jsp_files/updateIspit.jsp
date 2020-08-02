<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Izmeni ispit</title>
<link 
	rel="stylesheet" 
	type="text/css"
	href="../css/style.css"
/>
</head>
<body>

	<h1>IZMENI ISPIT</h1>
	
	<div class = "slikaProfesor">
		<a href = "profesorPage.jsp"> <img src = "../images/download.jpg" alt = "profesor" /></a>
	</div>
	
	<div>
		<form action = "../UpdateIspitController" method = "get">
	                                           <input type = "hidden" name = "idIspit" value = "${param.idOdIspita}">
			DA LI JE STUDENT IZASAO NA ISPIT           <input type="checkbox" name="checkIzasao" value="true"><br><br>
			DA LI JE STUDENT POLOZIO PRAKTICNI ISPIT   <input type="checkbox" name="checkPolozioPrakticni" value="true"><br><br>
			DA LI JE STUDENT POLOZIO USMENI ISPIT      <input type="checkbox" name="checkPolozioUsmeni" value="true"><br><br>
			              		                       <label for="rokovi">IZABERI ISPITNI ROK</label>
													   <select name="rok" id="rokovi">
														    <option value="januar">Januar</option>
														    <option value="april">April</option>
														    <option value="jun">Jun</option>
														    <option value="septembar">Septembar</option>
														    <option value="oktobar1">Oktobar 1</option>
														    <option value="oktobar2">Oktobar 2</option>
														    <option value="decembar">Decembar</option>
													   </select><br><br>
            DATUM ODRZAVANJA ISPITA                    <input type = "text" name = "datum"><br><br> 
			OSVOJENI POENI NA PRAKTICNOM ISPITU        <input type = "text" name = "poeniNaPrakticnom"><br><br> 		
			OSVOJENI POENI NA USMENOM ISPITU           <input type = "text" name = "poeniNaUsmenom"><br><br>
			                                           <label for="profesori">IZABERI PROFESORA</label>
													   <select name="profesor" id="profesori">
														    <option value="Anita Radovanovic">Anita Radovanovic</option>
														    <option value="Ivan Milosevic">Ivan Milosevic</option>
														    <option value="Tijana Luzajic Bozinovski">Tijana Luzajic Bozinovski</option>
														    <option value="Danica Markovic">Danica Markovic</option>
													   </select><br><br>
				                                           <input type = "submit" value = "IZMENI ISPIT">
		</form>		
	</div>
	
	
</body>
</html>