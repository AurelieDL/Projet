package fr.eni.java.projet.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.java.projet.bll.ArticleVenduManager;
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
			// Recuperation des parametres du formulaire --> ok 
			int noUtilisateur= Integer.valueOf(request.getParameter("noutilisateur"));
			String nom= request.getParameter("nom");
			String description= request.getParameter("description");
			String categorie= request.getParameter("categorie");
			//String photo= request.getParameter("photo");
			String mise= request.getParameter("mise");
			Date dde= request.getParameter("dde");
			String dfe= request.getParameter("dfe");
			String rue = request.getParameter("rue");
			int cp = Integer.valueOf(request.getParameter("cp"));
			String ville = request.getParameter("ville");
			
			// instanciation d'un objet retrait avec les paramètres d'adresse ( rue cp ville)---> OK 
			Retrait retrait = new Retrait(rue, cp, ville);
			
			// instanciation d'un objet ArticleeVendus avc TOUS les paramètres ( objet Retrait compris)--->OK
			ArticleVendu articleVendu= new ArticleVendu (nom, description, categorie, dde, dfe, mise, retrait); 
			
			// On instancie un manager pour se connecter( avec la fonction Ajouter qu'on a ecrit dans ArticleVenduManager(BLL))
			ArticleVenduManager articleVenduManager = new ArticleVenduManager();
			articleVenduManager.ajouter(articleVendu);
			
			// par la suite il faudra rediriger vers la page d'accueil en mode connecté.
			RequestDispatcher rd = request.getRequestDispatcher("pages/index.jsp");
			rd.forward(request, response);
			
	}

}
