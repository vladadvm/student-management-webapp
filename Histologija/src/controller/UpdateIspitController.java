package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ispit;
import service.UpdateIspitService;

/**
 * Servlet implementation class UpdateIspitController
 */
@WebServlet(description = "izmena ispita", urlPatterns = { "/UpdateIspitController" })
public class UpdateIspitController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UpdateIspitService service = new UpdateIspitService();
		
		String idIspit = request.getParameter("idIspit");
		String checkIzasao = request.getParameter("checkIzasao");
		String checkPolozioPrakticni = request.getParameter("checkPolozioPrakticni");
		String checkPolozioUsmeni = request.getParameter("checkPolozioUsmeni");
		String rok = request.getParameter("rok");
		String datum = request.getParameter("datum");
		String poeniNaPrakticnom = request.getParameter("poeniNaPrakticnom");
		String poeniNaUsmenom = request.getParameter("poeniNaUsmenom"); 
		String profesor = request.getParameter("profesor");
		
		Ispit ispit = service.vratiIspitSaOvimID(idIspit);
		boolean daLiJeBrojPoeniSaPrakticnog = service.proveriDaLiJeBroj(poeniNaPrakticnom);
		boolean daLiJeBrojPoeniSaUsmenog = service.proveriDaLiJeBroj(poeniNaUsmenom);
		//moze metoda koja ovo radi umesto kontrolera
		
		if(checkIzasao != null) {
			ispit.setDaLiJeStudentIzasaoNaIspit(Boolean.parseBoolean(checkIzasao));
		}
		if(checkPolozioPrakticni != null) {
			ispit.setDaLiJeStudentPolozioPrakticniIspit(Boolean.parseBoolean(checkPolozioPrakticni));
		}
		if(checkPolozioUsmeni != null) {
			ispit.setDaLiJeStudentPolozioUsmeniIspit(Boolean.parseBoolean(checkPolozioUsmeni));
		}
		if(!rok.isEmpty()) {
			ispit.setIspitniRok(rok);
		}
		if(!datum.isEmpty()) {
			ispit.setDatumOdrzavanjaIspita(datum);
		}
		if(!poeniNaPrakticnom.isEmpty() && daLiJeBrojPoeniSaPrakticnog) {
			ispit.setOsvojeniPoeniNaPrakticnom(Double.parseDouble(poeniNaPrakticnom));
		}
		if(!poeniNaUsmenom.isEmpty() && daLiJeBrojPoeniSaUsmenog) {
			ispit.setOsvojeniPoeniNaUsmenom(Double.parseDouble(poeniNaUsmenom));
		}
		if(!profesor.isEmpty()) {
			ispit.setDodeljenProfesor(profesor);
		}
		
		boolean daLiJeSnimioPromenjenogIspita = service.updateIspit(ispit);
		
		if(daLiJeSnimioPromenjenogIspita) {
			response.sendRedirect("html_files/uspesno.html");
		}else {
			response.sendRedirect("html_files/neuspesno.html");
		}
		
	}

}
