package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Profesori;
import service.PromeniPasswordService;

/**
 * Servlet implementation class PromeniPasswordController
 */
@WebServlet(description = "promena passworda", urlPatterns = { "/PromeniPasswordController" })
public class PromeniPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PromeniPasswordService service = new PromeniPasswordService();
		
		String idProfesora = request.getParameter("idProfesor");
		String sadasnjiPassword = request.getParameter("sadasnjiPassword");
		String noviPassword = request.getParameter("noviPassword");
		String potvrdiNoviPassword = request.getParameter("potvrdiNoviPassword");
		
		Profesori profesorIzBaze = service.vratiProfesoraSaOvimID(idProfesora);
		
		if(profesorIzBaze != null) {
			boolean poredimPassworde = service.uporediPassworde(sadasnjiPassword, profesorIzBaze.getPasswordProfesora());
			
			if(poredimPassworde) {
				boolean daLiJePasswordValidan = service.daLiJePasswordValidan(noviPassword);
				if(daLiJePasswordValidan) {
					boolean porediNoviIPotvrdjeniPassword = service.uporediPassworde(noviPassword, potvrdiNoviPassword);
				
					if(porediNoviIPotvrdjeniPassword) {
						boolean promeniPassword = service.promeniPassword(idProfesora, noviPassword);
						if(promeniPassword) {
							response.sendRedirect("html_files/uspesno.html");
						}else {
							System.out.println("Nisam promenio password");
							response.sendRedirect("html_files/neuspesno.html");
						}
					}else {
						System.out.println("Ne poklapaju se novi i potvrdjeni password");
						response.sendRedirect("html_files/neuspesno.html");
					}
				}
			}else {
				System.out.println("Password nije validan");
				response.sendRedirect("html_files/neuspesno.html");
			}
			
		}else {
			System.out.println("Nesto ne valja");
			response.sendRedirect("html_files/neuspesno.html");
		}
	}

}
