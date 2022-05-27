package fr.eni.java.projet.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.eni.java.projet.bll.LoginManager;
import fr.eni.java.projet.bo.Utilisateur;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("pages/login.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username ;
		String password ;
		
				username= request.getParameter("username");
				password= request.getParameter("password");
				LoginManager loginManager = new LoginManager();
				Utilisateur user = loginManager.Connecter(username, password);
				request.setAttribute("Utilisateur", user );
				RequestDispatcher rd = request.getRequestDispatcher("pages/profil.jsp");
				rd.forward(request, response);
				
	}

}
