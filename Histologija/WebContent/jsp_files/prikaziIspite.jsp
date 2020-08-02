<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "model.Student" %>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ispiti</title>
<link 
	rel="stylesheet" 
	type="text/css"
	href="../css/style.css"
/>
</head>
<body>

	<h1>Ispiti o ${student.ime}</h1>
		
	<div class = "slikaProfesor">
		<p>Klik na sliku za vracanje nazad.</p>
		<a href = "jsp_files/profesorPage.jsp">
			<img src = "images/download.jpg" alt = "profesor" />
		</a>
	</div>
	
	<br><br>

	<table border = "1" class = "prvaTabela">
		
		<tr>
			<th>ID</th>
			<th>Ispitni rok</th>
			<th>Datum</th>
			<th>Da li je student izasao na ispit</th>
			<th>Da li je polozio prakticni ispit u ovom roku</th>
			<th>Da li je polozio usmeni ispit u ovom roku</th>
			<th>Osvojeni poeni na prakticnom ispitu</th>
			<th>Osvojeni poeni na usmenom ispitu</th>
			<th>Dodeljen profesor</th>
		</tr>
		
		<c:forEach var = "u" items = "${ispiti}">
		
		<c:url var = "updateIspit" value = "jsp_files/updateIspit.jsp">
			<c:param name="idOdIspita" value = "${u.idIspit}"/>
		</c:url>
		
			<tr> 
				<td>${u.idIspit}</td>
				<td>${u.ispitniRok}</td>
				<td>${u.datumOdrzavanjaIspita}</td>
				<td>${u.daLiJeStudentIzasaoNaIspit}</td>
				<td>${u.daLiJeStudentPolozioPrakticniIspit}</td>
				<td>${u.daLiJeStudentPolozioUsmeniIspit}</td>
				<td>${u.osvojeniPoeniNaPrakticnom}</td>
				<td>${u.osvojeniPoeniNaUsmenom}</td>
				<td>${u.dodeljenProfesor}</td>
				<td><a href = "${updateIspit}">Izmeni ispita</a></td>
				<td>
					<form action="ObrisiIspitController" method = "get">
						<input type = "hidden" name = "idIspit" value = "${u.idIspit}">
						<input type = "submit" value = "Obrisi ispit">
					</form>
				</td>
			</tr>	 
		
		 </c:forEach>
	</table>
	
	
	
</body>
</html>