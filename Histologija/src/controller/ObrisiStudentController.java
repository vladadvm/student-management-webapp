package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ObrisiStudentService;

/**
 * Servlet implementation class ObrisiStudentController
 */
@WebServlet(description = "brisanje studenta", urlPatterns = { "/ObrisiStudentController" })
public class ObrisiStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObrisiStudentService service = new ObrisiStudentService();
		String idStudent = request.getParameter("idStudent");
		
		boolean daLiJeObrisaoStudent = service.obrisiIspitSaOvimID(idStudent);
		
		if(daLiJeObrisaoStudent) {
			response.sendRedirect("html_files/uspesno.html");
		}else {
			response.sendRedirect("html_files/neuspesno.html");
		}
	}

}
