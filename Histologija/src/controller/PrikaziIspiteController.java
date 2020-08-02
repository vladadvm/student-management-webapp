package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ispit;
import model.Student;
import service.PrikaziIspiteService;

/**
 * Servlet implementation class PrikaziIspiteController
 */
@WebServlet(description = "prikazivanje ispite", urlPatterns = { "/PrikaziIspiteController" })
public class PrikaziIspiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrikaziIspiteService service = new PrikaziIspiteService();
		
		String idStudent = request.getParameter("idStudent");
		Student student = service.vratiStudentaSaOvimID(idStudent);
		List<Ispit> ispiti = new ArrayList<>();
		//da li je potrebno slati i studenta i listu, mozda moze samo studenta pa da se iz njega vade ispite
		if(student != null) {
			ispiti = student.getIspiti();
			request.setAttribute("student", student);
			request.setAttribute("ispiti", ispiti);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp_files/prikaziIspite.jsp");
			dispatcher.forward(request, response);
			
		}else {
			response.sendRedirect("jsp_files/profesorPage.jsp");
		}
		
		
		
		
	}
}
