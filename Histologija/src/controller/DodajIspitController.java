package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ispit;
import model.Profesori;
import model.Student;
import service.DodajIspitService;

/**
 * Servlet implementation class DodajIspitController
 */
@WebServlet(description = "dodavanje ispita", urlPatterns = { "/DodajIspitController" })
public class DodajIspitController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DodajIspitService service = new DodajIspitService();
		
		String idStudent = request.getParameter("idStudent");
		String daLiJeStudentIzasao = request.getParameter("checkIzasao");
		String daLiJeStudentPolozioPrakticniIspit = request.getParameter("checkPolozioPrakticni");
		String daLiJeStudentPolozioUsmeniIspit = request.getParameter("checkPolozioUsmeni");
		String ispitniRok = request.getParameter("rok");
		String datum = request.getParameter("datum");
		String poeniSaPrakticnogIspita = request.getParameter("poeniNaPrakticnom");
		String poeniSaUsmenogIspita = request.getParameter("poeniNaUsmenom");
		String dodeljenProfesor = request.getParameter("profesor");
		
		boolean daLiJeBrojPoeniSaPrakticnog = service.proveriDaLiJeBroj(poeniSaPrakticnogIspita);
		boolean daLiJeBrojPoeniSaUsmenog = service.proveriDaLiJeBroj(poeniSaUsmenogIspita);
		
		if(daLiJeBrojPoeniSaPrakticnog && daLiJeBrojPoeniSaUsmenog) {
			Ispit ispit = service.napraviIspit(daLiJeStudentIzasao, daLiJeStudentPolozioPrakticniIspit, daLiJeStudentPolozioUsmeniIspit,
					ispitniRok, datum, poeniSaPrakticnogIspita, poeniSaUsmenogIspita, dodeljenProfesor);
			
			boolean daLiJeSpojioIspitIStudent = service.dodajOvajIspitUListuIspitaStudentaSaOvimID(idStudent, ispit);
			
			if(daLiJeSpojioIspitIStudent) {
				response.sendRedirect("html_files/uspesno.html");
			}else {
				response.sendRedirect("html_files/neuspesno.html");
			}
		}else {
			response.sendRedirect("html_files/neuspesno.html");
		}
		
		
		
		
		
	
		
		
	}

}
