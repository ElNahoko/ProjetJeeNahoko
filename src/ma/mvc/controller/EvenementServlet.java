package ma.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.mvc.Dao.Evenementdao;
import ma.mvc.Model.Evenement;

@WebServlet("/EvenementServlet")
public class EvenementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		RequestDispatcher R = request.getRequestDispatcher("Cal.jsp");
		R.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Evenementdao AOA = new Evenementdao();
		Evenement E = new Evenement("Visiter Rania Chez Soit");
		try {
			List<Evenement> R = AOA.ShowEvenement();
			request.setAttribute("E", R);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			AOA.AddEven(E);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}

}
