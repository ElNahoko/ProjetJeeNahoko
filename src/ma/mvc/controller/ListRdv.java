package ma.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ma.mvc.Dao.RendezVousDao;
import ma.mvc.Model.Modele;
import ma.mvc.Model.RendezVousBeans;


@WebServlet("/ListRdv")
public class ListRdv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RendezVousDao rendezVousDao;
    
	public void init() throws ServletException {
		rendezVousDao=new RendezVousDao();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("Add")) {
			try {
				AjouterRdv( request,  response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		if(action.equalsIgnoreCase("Supprimer")) {
			DeleteRDV(request, response);
		}if(action.equalsIgnoreCase("Modifier")) {
			int id = Integer.parseInt(request.getParameter("id"));
			RendezVousBeans A = rendezVousDao.Chercher(id);
			request.setAttribute("rdv", A);
			RequestDispatcher R = request.getRequestDispatcher("Form.jsp");
			R.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		  Modele M = new Modele();
		    try {
				M.setRDV(rendezVousDao.ShowRDV());
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			
		 request.setAttribute("M", M);
		 
		 request.getRequestDispatcher("datatables.jsp").forward(request, response);
        
	}
	private void DeleteRDV(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		
		System.out.print(id);
		RendezVousDao DAO = new RendezVousDao();
		RendezVousBeans BEAN = new RendezVousBeans(id);
		
    	DAO.Supprimer(BEAN);
    	try {
			doPost(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
	private void AjouterRdv(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException ,SQLException{


		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		    String NOM_PAT = request.getParameter("nom");
		    String PRENOM_PAT = request.getParameter("prenom");
	        String Motif = request.getParameter("motif");
	        String NumF = request.getParameter("tele");
	        String date = request.getParameter("date");
	        String Heure = request.getParameter("heure");
		    String id = request.getParameter("id");
		    System.out.println(id);
		    RendezVousBeans R5 = new RendezVousBeans(NOM_PAT,PRENOM_PAT,date,Heure,Motif,NumF);
	        RendezVousDao RD = new RendezVousDao();
         if (id == null || id.isEmpty()) {
        	 System.out.println("existe deje");
				if(RD.CheckRDv(R5) == 1) {
					
					   out.println("<script type=\"text/javascript\">");
					   out.println("alert('Il exist deja un Rendez Vous a Cet Heure');");
					   out.println("location='appointment.jsp';");
					   out.println("</script>");
					   doPost(request, response);}else {
						    RD.AddRdv(R5);
							doPost(request, response);
							System.out.println("Ajouter Avec Succ�es");}
						
			 
         }else {
        	 System.out.println("update le rdv deje");
				R5.setId_Rdv(Integer.parseInt(id));
				rendezVousDao.Modifier(R5);
				doPost(request, response);
			}     
	}


	

}
