package fr.eni.java.projet.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.java.projet.bll.UtilisateurManager;
import fr.eni.java.projet.bo.Utilisateur;
import fr.eni.java.projet.exceptions.BusinessException;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/ServletInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("pages/Inscription.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// D'abord il faut récupérer les données saisies dans le formulaire de la jsp inscription.jsp
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");
		// On instancie Utilisateur pour empaqueter tout ça dans un colis pour la BDD
		Utilisateur utilisateurCréé = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
		
		// Puis instancier UtilisateurManager
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		// C'est ICI qu'on fait un aller-retour IHM-DAL en passant par la BLL pour livrer le paquet à la BDD
		// C'est aussi là que le Manager va contrôler pour s'assurer que la saisie respecte bien les critères demandés, puisqu'il est la porte d'entrée du chemin
		Utilisateur user;
		
			user = utilisateurManager.Créer(utilisateurCréé);
			System.out.println(user.toString());
			//On récupère la session avec tous les renseignements du profil, donc pas besoin de se connecter après
			session.setAttribute("Utilisateur", user );
			System.out.println("Ces valeurs sont stockées comme attribut à la clé Utilisateur");
			
		
		RequestDispatcher rd = request.getRequestDispatcher("");
		rd.forward(request, response);
	}

}
