package fr.eni.java.projet.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.java.projet.bll.ArticleManager;
import fr.eni.java.projet.bll.UtilisateurManager;
import fr.eni.java.projet.bo.ArticleVendu;
import fr.eni.java.projet.bo.Retrait;
import fr.eni.java.projet.bo.Utilisateur;

@WebServlet("/SellArticle")
public class SellArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("/pages/formulaire_vente.jsp");
		rd.forward(request, response);
	}

	

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//
			// Recuperation des parametres du formulaire
			String name= request.getParameter("name");
			String description= request.getParameter("description");
			
			String rue = request.getParameter("rue");
			int cp = Integer.valueOf(request.getParameter("cp"));
			String ville = request.getParameter("ville");
			
			// instanciation d'un objet retrait avec les paramètres d'adresse ( rue cp ville)---> OK 
			Retrait retrait = new Retrait(rue, cp, ville);
			
			// instanciation d'un objet ArticleeVendus avc TOUS les paramètres ( objet Retrait compris)--->OK
			ArticleVendu articleVendu= new ArticleVendu(name, description, , , , , , retrait, ,  );
			// On instancie un manager pour se connecter( avec la fonction Ajouter qu'on a ecrit dans ArticleManager(BLL))
			ArticleManager articleManager = new ArticleManager();
			articleManager.ajouter(articleVendu);
			
			// par la suite il faudra rediriger vers la page d'accueil en mode connecté.
			RequestDispatcher rd = request.getRequestDispatcher("pages/index.jsp");
			rd.forward(request, response);
			
	}

}
