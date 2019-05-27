package ma.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.mvc.Model.*;
import ma.mvc.Dao.*;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		  PrintWriter out = response.getWriter();
   

		 String Email = request.getParameter("user");
		 String Password = request.getParameter("mdp");
		 UsersBeans  U = new UsersBeans(Email,Password);
		 
		 System.out.println(Email + " " + Password);
		 if(UsersDao.ValidateUser(U)) {
			 // La redirection vers une Servlet;
			 HttpSession session =request.getSession();//initier lobj session
			 session.setAttribute("user",U.getUsername());
			 this.getServletContext().getRequestDispatcher("/List").forward(request, response);
		 }else {
			  out.println("Username or Password incorrect");
			  System.out.println("NOT GOOD");
			  request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
}
