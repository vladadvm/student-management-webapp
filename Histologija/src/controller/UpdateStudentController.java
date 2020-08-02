package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;
import service.UpdateStudentService;

/**
 * Servlet implementation class UpdateStudentController
 */
@WebServlet(description = "ubacivanja podataka o studentu", urlPatterns = { "/UpdateStudentController" })
public class UpdateStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UpdateStudentService service = new UpdateStudentService();
				
		String idStudent = request.getParameter("idStudent");
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		String brojIndeksa = request.getParameter("brojIndeksa");
		String grupa = request.getParameter("grupa");
		String pol = request.getParameter("pol");
		String zabeleske = request.getParameter("zabeleske");
		String ocena = request.getParameter("ocena");
		
		boolean daLiJeBroj = service.proveriDaLiJeBroj(grupa);
		
		if(daLiJeBroj) {
			Student student = service.vratiStudentaSaOvimID(idStudent);
			//moze metoda koja ovo radi umesto kontrolera
			
			if(!ime.isEmpty()) {
				student.setIme(ime);
			}
			if(!prezime.isEmpty()) {
				student.setPrezime(prezime);
			}
			if(!brojIndeksa.isEmpty()) {
				student.setBrojIndeksa(brojIndeksa);
			}
			if(!grupa.isEmpty()) {
				student.setGrupa(Integer.parseInt(grupa));
			}
			if(pol != null) {
				student.setPol(pol);
			}
			if(!zabeleske.isEmpty()) {
				student.setZabeleske(zabeleske);
			}
			if(!ocena.isEmpty()) {
				student.setOcena(Integer.parseInt(ocena));
			}
			
			
			boolean daLiJeSnimioPromenjenogStudenta = service.updatePromenjenogStudenta(student);
			
			if(daLiJeSnimioPromenjenogStudenta) {
				response.sendRedirect("html_files/uspesno.html");
			}else {
				response.sendRedirect("html_files/neuspesno.html");
			}
		}else {
			System.out.println("Nije unet int u polje grupa");
			response.sendRedirect("html_files/neuspesno.html");
		}
		
		
	}
}
