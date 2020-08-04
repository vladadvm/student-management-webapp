package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import service.DodajPoeneService;

/**
 * Servlet implementation class DodajPoeneController
 */
@WebServlet(description = "dodavanje poena", urlPatterns = { "/DodajPoeneController" })
public class DodajPoeneController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DodajPoeneService service = new DodajPoeneService();
		
		String idStudent = request.getParameter("idStudent");
        String poeniNaIKol = request.getParameter("poeniNaIKol");
        String poeniNaIIKol = request.getParameter("poeniNaIIKol");
        String poeniNaIIIKol = request.getParameter("poeniNaIIIKol");
        String poeniSaVezbi = request.getParameter("poeniSaVezbi");
        String poeniSaPredavanja = request.getParameter("poeniSaPredavanja");
        
        Student student = service.vratiStudentaSaOvimID(idStudent);
        
        boolean daLiJeDodaoPoene = service.dodajPoeneStudentu(poeniNaIKol, poeniNaIIKol, poeniNaIIIKol, poeniSaVezbi, poeniSaPredavanja, student);
        		
		if(daLiJeDodaoPoene) {
			boolean daLiJeSnimioPromenjenogStudenta = service.updatePromenjenogStudenta(student);
			if(daLiJeSnimioPromenjenogStudenta) {
				response.sendRedirect("html_files/uspesno.html");
			}else {
				response.sendRedirect("html_files/neuspesno.html");
			}
		}else {
			response.sendRedirect("html_files/neuspesno.html");
		}
        
		
		
	}
}
