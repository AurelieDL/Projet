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
				Utilisateur user = null;
				try {
					//On se connecte en passant en paramètres le username et le password
					user = utilisateurManager.Connecter(username, password);
					
					// On recupère la session, et on definit un attribut "user" avec le user qu'on a recupere par le manager
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
												
					// par la suite il faudra rediriger vers la page d'accueil en mode connecté.
					RequestDispatcher rd = request.getRequestDispatcher("Accueil");
					rd.forward(request, response);
				} catch (BusinessException e) {
					
					// Si l'utilisateur manager "throw" une exception , on recupère les saisies effectuées précedemment (username / password)
					request.setAttribute("username", username);
					request.setAttribute("password", password);
					
					// Si l'utilisateur manager "throw" une exception , on recupère la liste d'erreurs
					// qu'on passe en parametre du request avec le username et le password
					//pour eviter de vider le formulaire à chaque erreur
					request.setAttribute("erreurs", e.getListeCodesErreur());
					
					System.out.println("Erreurs(servlet) : " + e.getListeCodesErreur());
					
					// par la suite il faudra rediriger vers la page d'accueil en mode connecté.
					RequestDispatcher rd = request.getRequestDispatcher("pages/login.jsp");
					rd.forward(request, response);
				}
				
				
				
	}

}
