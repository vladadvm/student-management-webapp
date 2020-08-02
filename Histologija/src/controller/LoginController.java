package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Profesori;
import service.LoginService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(description = "tu se vrsi logovanje profesora", urlPatterns = { "/LoginController" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginService service = new LoginService();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Profesori profesorIzBaze = service.vratiProfesoraSaOvimUsernameom(username);
		
		if(profesorIzBaze != null) {
			boolean poredimPassworde = service.uporediPassworde(password, profesorIzBaze.getPasswordProfesora());
			
			if(poredimPassworde) {
				System.out.println("OK je pass");
				
				HttpSession sessionObject = request.getSession();
				
				sessionObject.setAttribute("profesor", profesorIzBaze);
				
				response.sendRedirect("jsp_files/profesorPage.jsp");
				
			}else {
				System.out.println("Los je pass");
				response.sendRedirect("html_files/neuspesno.html");
			}
		}else {
			response.sendRedirect("html_files/neuspesno.html");
		}
		
	}

}
