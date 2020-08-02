<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "model.Profesori" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Promena passworda</title>
<link 
	rel="stylesheet" 
	type="text/css"
	href="../css/style.css"
/>
</head>
<body>

	<% 
		Profesori profesor = (Profesori) session.getAttribute("profesor");
	%>

	<h1>Promeni password</h1>

	<div class = "slikaProfesor">
	
		<a href = "profesorPage.jsp"> <img src = "../images/download.jpg" alt = "profesor" /></a>
			
	</div>
	
	<div>
		<form action="../PromeniPasswordController" method="get">
			<input type = "hidden" name = "idProfesor" value = "${profesor.idProfesora}">
			<table>	
				<tr>
					<td>Sadasnji password</td><td><input type="password" name="sadasnjiPassword"></td>
				</tr>
				<tr>
					<td>Novi password</td><td><input type="password" name="noviPassword"></td>
					<td>
						Password mora biti duzi od 8, a kraci od 15 karaktera, mora sadrzati bar jedno veliko slovo,
						bar jedno malo slovo, bar jedan broj i jedan od sledecih znakova @#$%.
					</td>															 
				</tr>
				<tr>
					<td>Potvrdi novi password</td><td><input type="password" name="potvrdiNoviPassword"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Promeni password"></td>
				</tr>
			</table>
		</form>
	</div>
	
</body>
</html>