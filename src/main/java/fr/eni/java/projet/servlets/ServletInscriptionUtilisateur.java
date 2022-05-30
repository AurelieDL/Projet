package fr.eni.java.projet.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.java.projet.bll.UtilisateurManager;
import fr.eni.java.projet.bo.Utilisateur;

/**
 * Servlet implementation class ServletInscriptionUtilisateur
 */
@WebServlet("/ServletInscriptionUtilisateur")
public class ServletInscriptionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/pages/Inscription.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pseudo = (String) request.getParameter("pseudo");
		String nom = (String) request.getParameter("nom");
		String prenom = (String) request.getParameter("prenom");
		String email = (String) request.getParameter("email");
		String telephone = (String) request.getParameter("tel");
		String rue = (String) request.getParameter("rue");
		String codePostal = (String) request.getParameter("cp");
		String ville = (String) request.getParameter("ville");
		String motDePasse = (String) request.getParameter("mdp");
		
		// Il faudra bien envoyer les infos vers le bas ! J'ai repris l'exemple de ajoutAvis
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		
		// Là il faut faire référence à une méthode qu'on créera dans UtilisateurManager
		//Utilisateur utilisateur = utilisateurManager.ajouter();
		
		doGet(request, response);
	}

}
