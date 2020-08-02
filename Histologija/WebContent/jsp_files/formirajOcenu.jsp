<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formiranje ocene</title>
<link 
	rel="stylesheet" 
	type="text/css"
	href="../css/style.css"
/>
</head>
<body>
	<h1>
		Formiranje ocene
	</h1>
	
	<div class = "slikaProfesor">
		<p>
			Klik na sliku za vracanje nazad.
		</p>
		
		<a href = "profesorPage.jsp">
			<img src = "../images/download.jpg" alt = "profesor" />
		</a>
	</div>
	
	<div>
		<form action = "../FormirajOcenuController" method = "get">
			                                                 <input type = "hidden" name = "idStudent" value = "${param.idOdStudenta}"><br><br>
			Uneti datum uspenog polaganja prakticnog ispita  <input type = "text" name = "datumPolaganjaPrakticnogIspita"><br><br>
			Uneti datum uspenog polaganja usmenog ispita     <input type = "text" name = "datumPolaganjaUsmenogIspita"><br><br>
														     <input type = "submit" value = "Formiraj ocenu">	
		</form>
	</div>
	
	
</body>
</html>