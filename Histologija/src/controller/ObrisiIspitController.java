package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ObrisiIspitService;

/**
 * Servlet implementation class ObrisiIspitController
 */
@WebServlet(description = "brisanje ispita", urlPatterns = { "/ObrisiIspitController" })
public class ObrisiIspitController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObrisiIspitService service = new ObrisiIspitService();
		String idIspit = request.getParameter("idIspit");
		
		boolean daLiJeObrisaoIspit = service.obrisiIspitSaOvimID(idIspit);
		
		if(daLiJeObrisaoIspit) {
			response.sendRedirect("html_files/uspesno.html");
		}else {
			response.sendRedirect("html_files/neuspesno.html");
		}
		
	}

}
