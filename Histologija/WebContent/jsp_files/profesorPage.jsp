<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "model.Profesori" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profesor Page</title>
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
	
	<h1>Dobrodosli na svoju stranu, profesore/ka <%=profesor.getImeProfesora() %> </h1>
	
	<a href = "../LogoutController"><button>Log out</button></a>
	
	 <br><br>
	
	<div class = "slikaProfesor">

		<img src = "../images/download.jpg" alt = "profesor" />
		
	</div>
	
	<br><br>
	
	<table border = "1" class = "prvaTabela">
		<tr>
			<th>ID</th>
			<th>IME</th>
			<th>PREZIME</th>
			<th>USERNAME</th>
		</tr>
		
		<tr>
		
			<td><%=profesor.getIdProfesora() %></td>
			<td><%=profesor.getImeProfesora() %></td>
			<td><%=profesor.getPrezimeProfesora() %></td>
			<td><%=profesor.getUsernameProfesora() %></td>
			
		</tr>
	
	</table>
	
	<br><br><br>
	
	<div>
		
		<a href = "../html_files/dodajStudenta.html">
			<button>DODAJ STUDENTA</button>
		</a>
		
		<br><br>
		
		<form action="../ProfesorStudentController" method = "get">
		
			<input type = "submit" value = "PRIKAZI SVE STUDENTE">
	
		</form>
	
		<br>
		
		<a href = "promeniPassword.jsp"><button>PROMENI PASSWORD</button></a>
		
	</div>
	
	
	
	
</body>
</html>