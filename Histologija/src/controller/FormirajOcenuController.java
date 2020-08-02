package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;
import model.Ispit;
import model.Poeni;
import service.FormirajOcenuService;

/**
 * Servlet implementation class FormirajOcenuController
 */
@WebServlet(description = "formiranje ocene", urlPatterns = { "/FormirajOcenuController" })
public class FormirajOcenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FormirajOcenuService service = new FormirajOcenuService();
		String idStudent = request.getParameter("idStudent");
		String datumUspesnogPolaganjaPrakticnogIspita = request.getParameter("datumPolaganjaPrakticnogIspita");
		String datumUspesnogPolaganjaUsmenogIspita = request.getParameter("datumPolaganjaUsmenogIspita");
		
		Student student = service.vratiStudentaSaOvimID(idStudent);
		
		Poeni poeni = student.getPoeni();
			
		Ispit prakticniIspit = new Ispit();
		Ispit usmeniIspit = new Ispit();
		
		List<Ispit> ispiti = new ArrayList<>();
		ispiti = student.getIspiti();
		
		for(Ispit i: ispiti) {
			
			if(i.getDatumOdrzavanjaIspita().equals(datumUspesnogPolaganjaPrakticnogIspita)) {
				prakticniIspit = i;
				System.out.println("ter");
			}	
		}		
		
		for(Ispit i: ispiti) {
			
			if(i.getDatumOdrzavanjaIspita().equals(datumUspesnogPolaganjaUsmenogIspita)) {
				usmeniIspit = i;
				System.out.println("ter");
			}	
		}	
		
		double poeniSaPrakticnogIspita = prakticniIspit.getOsvojeniPoeniNaPrakticnom();
		double poeniSaUsmenogIspita = usmeniIspit.getOsvojeniPoeniNaUsmenom();
		double poeniSaKolokvijuma = poeni.getPoeniSaPrvogKolokvijuma()+poeni.getPoeniSaDrugogKolokvijuma()+poeni.getPoeniSaTrecegKolokvijuma();
		double poeniSaPredavanja = poeni.getUkupniPoeniSaPredavanja();
		double poeniSaVezbi = poeni.getUkupanBrojPoenaSaVezbi();
		double predispitniPoeni = poeniSaKolokvijuma + poeniSaPredavanja + poeniSaVezbi;
		double ukupniPoeni = poeniSaPrakticnogIspita + poeniSaUsmenogIspita + predispitniPoeni;
		
		int ocena = service.napraviOcenu(ukupniPoeni);
		
		poeni.setPredispitniPoeni(predispitniPoeni);
		poeni.setUkupniPoeniSaKolokvijuma(poeniSaKolokvijuma);
		poeni.setUkupniPoeni(ukupniPoeni);
		
		boolean daLiJeSnimioPromenjenePoene = service.snimiPromenjenoPoene(poeni);
		boolean daLiJeSnimioOcenu = service.snimiOcenu(ocena, student);
		
		if(daLiJeSnimioPromenjenePoene && daLiJeSnimioOcenu) {
			response.sendRedirect("html_files/uspesno.html");
		}else {
			response.sendRedirect("html_files/neuspesno.html");
		}
		
		
	}
}
