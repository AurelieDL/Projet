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
import javax.servlet.http.HttpSession;

import fr.eni.java.projet.bll.UtilisateurManager;
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
		

				// Recuperation des parametres du formulaire
				String username= request.getParameter("username");
				String password= request.getParameter("password");
			
				// On instancie un manager pour se connecter( avec la fonction Connecter qu'on a ecrit dans LoginManager(BLL))
				UtilisateurManager utilisateurManager = new UtilisateurManager();
				Utilisateur user = utilisateurManager.Connecter(username, password);
				
				// On recupère la session, et on definit un attribut avec le user qu'on a recupere par le manager
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				
				// par la suite il faudra rediriger vers la page d'accueil en mode connecté.
				RequestDispatcher rd = request.getRequestDispatcher("Accueil");
				rd.forward(request, response);
				
	}

}
