<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "model.Student" %>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link 
	rel="stylesheet" 
	type="text/css"
	href="../css/style.css"
/>
<meta charset="ISO-8859-1">
<title>Tabela studenata</title>
</head>

<body>
	 
	<h1>TABELA SVIH STUDENATA</h1>

	<div class = "slikaProfesor">
			<p>Klik na sliku za vracanje nazad.</p>
			<a href = "jsp_files/profesorPage.jsp"> <img src = "images/download.jpg" alt = "profesor" /></a>
			
	</div>
	
	<br><br>

	<table border = "1" class = "prvaTabela">
		
		<tr>
			<th>ID</th>
			<th>Broj indeksa</th>
			<th>Grupa</th>
			<th>Pol</th>
			<th>Ime</th>
			<th>Prezime</th>
			<th>Zabeleske</th>
			<th>Ocena</th>
		</tr>
		
		
		
		<c:forEach var = "u" items = "${listaStudenta}">
		
		<c:url var = "updateStudent" value = "jsp_files/updateStudent.jsp">
			<c:param name="idOdStudenta" value = "${u.idStudenta}"/>
		</c:url>
		
		<c:url var = "dodajIspit" value = "jsp_files/dodajIspit.jsp">
			<c:param name="idOdStudenta" value = "${u.idStudenta}"/>
		</c:url>
		
		<c:url var = "dodajPoene" value = "jsp_files/dodajPoene.jsp">
			<c:param name="idOdStudenta" value = "${u.idStudenta}"/>
		</c:url>
		<c:url var = "formirajOcenu" value = "jsp_files/formirajOcenu.jsp">
			<c:param name="idOdStudenta" value = "${u.idStudenta}"/>
		</c:url>
			<tr> 
				<td>${u.idStudenta}</td>
				<td>${u.brojIndeksa}</td>
				<td>${u.grupa}</td>
				<td>${u.pol}</td>
				<td>${u.ime}</td>
				<td>${u.prezime}</td>
				<td>${u.zabeleske}</td>
				<td>${u.ocena}</td>
				
				<td><a href = "${updateStudent}"><button>Izmeni studenta</button></a></td>
				<td><a href = "${dodajIspit}"><button>Dodaj ispit</button></a></td>
				<td><a href = "${dodajPoene}"><button>Dodaj poene</button></a></td>
				<td><a href = "${formirajOcenu}"><button>Formiraj ocenu</button></a></td>
				<td>
					<form action="PrikaziIspiteController" method = "get">
						<input type = "hidden" name = "idStudent" value = "${u.idStudenta}">
						<input type = "submit" value = "Prikazi ispite">
					</form>
				</td>
				<td>
					<form action="ObrisiStudentController" method = "get">
						<input type = "hidden" name = "idStudent" value = "${u.idStudenta}">
						<input type = "submit" value = "Obrisi student">
					</form>
				</td>
				
			</tr>	 
		
		 </c:forEach>
		 
		 
		
		
	
	
	</table>



</body>
</html>