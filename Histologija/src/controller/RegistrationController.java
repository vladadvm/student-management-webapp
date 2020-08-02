package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Profesori;
import service.RegistrationService;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet(description = "tu se vrsi registracija novih clanova", urlPatterns = { "/RegistrationController" })
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RegistrationService service = new RegistrationService();
		
		//prihvatamo podatke iz request-a
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repeatedPassword = request.getParameter("repeatedPassword");
		
		//prolazimo validaciju
		
		boolean daLiJePasswordValidan = service.daLiPasswordImaMinOsamKaraktera(password);
		
		if(daLiJePasswordValidan) {
			boolean daLiSuPasswordIRepeatedPasswordIsti = service.daliSuPasswordIRepeatedPasswordIsti(password, repeatedPassword);
			if(daLiSuPasswordIRepeatedPasswordIsti) {
				//pravimo model
				Profesori profesor = service.kreirajProfesora(ime, prezime, username, password);
				
				//snimamo usera u bazu
				boolean daLiJeSacuvanProfesor = service.daLiJeSacuvanProfesor(profesor);
				
				//vracamo view
				if(daLiJeSacuvanProfesor) {
					System.out.println("Sve je ok");
					response.sendRedirect("html_files/uspesno.html");
				}else {
					System.out.println("Nesto nije uspelo");
					response.sendRedirect("html_files/registracija.html");
				}
			}else {
				System.out.println("Ne poklapaju se passwordi");
				response.sendRedirect("html_files/registracija.html");
			}
		}else {
			System.out.println("Password nije validan");
			response.sendRedirect("html_files/neuspesno.html");
		}
		
		
		
		
		
		
	}

}
