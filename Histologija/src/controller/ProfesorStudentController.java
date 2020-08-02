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

import model.Student;
import service.ProfesorStudentService;

/**
 * Servlet implementation class ProfesorStudentController
 */
@WebServlet(description = "tu se vrsi promena podataka o studentu", urlPatterns = { "/ProfesorStudentController" })
public class ProfesorStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProfesorStudentService service = new ProfesorStudentService();
		
		List<Student> sviStudentiIzBaze = new ArrayList<>();
		
		sviStudentiIzBaze = service.vratiSveStudenteIzBaze();
		
		if(sviStudentiIzBaze != null) {
			
			
			request.setAttribute("listaStudenta", sviStudentiIzBaze);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp_files/profesorStudent.jsp");
			dispatcher.forward(request, response);
			
		}else {
			response.sendRedirect("jsp_files/profesorPage.jsp");
		}
		
	}

}
