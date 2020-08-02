package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Poeni;
import model.Student;
import service.DodajStudentService;

/**
 * Servlet implementation class DodajStudentController
 */
@WebServlet(description = "tu se dodaju novi studenti", urlPatterns = { "/DodajStudentController" })
public class DodajStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DodajStudentService service = new DodajStudentService();
		
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		String brojIndeksa = request.getParameter("brojIndeksa");
		String grupa = request.getParameter("grupa");
		String pol = request.getParameter("pol");
		
		boolean daLiJeBroj = service.proveriDaLiJeBroj(grupa);
		
		if(daLiJeBroj) {
			Poeni poeni = new Poeni();
			Student student = service.napraviStudent(ime, prezime, brojIndeksa, grupa, pol, poeni);
			
			boolean daLiJeSacuvanStudent = service.sacuvajStudent(student);
			
			if(daLiJeSacuvanStudent) {
				response.sendRedirect("jsp_files/profesorPage.jsp");
			}else {
				response.sendRedirect("html_files/dodajStudenta.html");
			}
		}else {
			System.out.println("Nije unet int u polje grupa");
			response.sendRedirect("html_files/neuspesno.html");
		}
		
		
		
		
		
		
	}
}
