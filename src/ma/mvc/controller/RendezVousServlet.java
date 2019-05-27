package ma.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.mvc.Model.*;
import ma.mvc.Dao.*;

@WebServlet("/RendezVousServlet")
public class RendezVousServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/appointment.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String action = request.getParameter("Action");
		if(action.equalsIgnoreCase("Add")) {
			try {
				InsertRDV(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	private void InsertRDV(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
		
		System.out.println(" HI IM POST");
		
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String NOM_PAT = request.getParameter("nom");
	    String PRENOM_PAT = request.getParameter("Prenom");
        String Motif = request.getParameter("motif");
        String NumF = request.getParameter("num");
        String date = request.getParameter("date");
        String Heure = request.getParameter("heure");
        
        RendezVousBeans R = new RendezVousBeans(NOM_PAT,PRENOM_PAT,date,Heure,Motif,NumF);
        RendezVousDao RD = new RendezVousDao();
        try {
			if(RD.CheckRDv(R) == 1) {
				
				   out.println("<script type=\"text/javascript\">");
				   out.println("alert('Il exist deja un Rendez Vous a Cet Heure');");
				   out.println("location='appointment.jsp';");
				   out.println("</script>");
			}
			else {
			
			try {
			
				RD.AddRdv(R);
				response.sendRedirect("index.jsp");
				System.out.println("Ajouter Avec Succ�es");
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	

}
