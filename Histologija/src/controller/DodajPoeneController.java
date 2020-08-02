package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Poeni;
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
        
        boolean daLiJeBrojIKol = service.proveriDaLiJeBroj(poeniNaIKol);
        boolean daLiJeBrojIIKol = service.proveriDaLiJeBroj(poeniNaIIKol);
        boolean daLiJeBrojIIIKol = service.proveriDaLiJeBroj(poeniNaIIIKol);
        boolean daLiJeBrojVezbi = service.proveriDaLiJeBroj(poeniSaVezbi);
        boolean daLiJeBrojPredavanja = service.proveriDaLiJeBroj(poeniSaPredavanja);
        
        //moze metoda i za ovo
        if(!poeniNaIKol.isEmpty() && daLiJeBrojIKol) {
        	student.getPoeni().setPoeniSaPrvogKolokvijuma(Double.parseDouble(poeniNaIKol));
        }
        if(!poeniNaIIKol.isEmpty() && daLiJeBrojIKol) {
        	student.getPoeni().setPoeniSaDrugogKolokvijuma(Double.parseDouble(poeniNaIIKol));
        }
        if(!poeniNaIIIKol.isEmpty() && daLiJeBrojIIIKol) {
        	student.getPoeni().setPoeniSaTrecegKolokvijuma(Double.parseDouble(poeniNaIIIKol));
        }
        if(!poeniSaVezbi.isEmpty() && daLiJeBrojVezbi) {
        	student.getPoeni().setUkupanBrojPoenaSaVezbi(Double.parseDouble(poeniSaVezbi));
        }
        if(!poeniSaPredavanja.isEmpty() && daLiJeBrojPredavanja) {
        	student.getPoeni().setUkupniPoeniSaPredavanja(Integer.parseInt(poeniSaPredavanja));
        }
        
        
        
        boolean daLiJeSnimioPromenjenogStudenta = service.updatePromenjenogStudenta(student);
		
		if(daLiJeSnimioPromenjenogStudenta) {
			response.sendRedirect("html_files/uspesno.html");
		}else {
			response.sendRedirect("html_files/neuspesno.html");
		}
        
		
		
	}
}
