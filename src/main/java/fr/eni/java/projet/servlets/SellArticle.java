package fr.eni.java.projet.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.java.projet.bll.ArticleVenduManager;
import fr.eni.java.projet.bo.ArticleVendu;
import fr.eni.java.projet.bo.Categorie;
import fr.eni.java.projet.bo.Retrait;

@WebServlet("/SellArticle")
public class SellArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArticleVenduManager articleVenduManager = new ArticleVenduManager();
		
		List<Categorie> categories = articleVenduManager.recupererCategories();
		
		request.setAttribute("categories", categories);
		
		RequestDispatcher rd = request.getRequestDispatcher("/pages/formulaire_vente.jsp");
		rd.forward(request, response);
	}

	

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//
			// Recuperation des parametres du formulaire --> ok 
			int noUtilisateur= Integer.valueOf(request.getParameter("noutilisateur"));
			String nom= request.getParameter("nom");
			String description= request.getParameter("description");
			int categorie= Integer.valueOf(request.getParameter("categorie"));
			//String photo= request.getParameter("photo");
			double mise= Double.valueOf(request.getParameter("mise"));
			Date dde = null;
			try {
				dde = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dde"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Date dfe = null;
			try {
				dfe = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dfe"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String rue = request.getParameter("rue");
			int cp = Integer.valueOf(request.getParameter("cp"));
			String ville = request.getParameter("ville");
			
			// instanciation d'un objet retrait avec les paramètres d'adresse ( rue cp ville)---> OK 
			Retrait retrait = new Retrait(rue, cp, ville);
			
			// instanciation d'un objet ArticleeVendus avc TOUS les paramètres ( objet Retrait compris)--->OK
			ArticleVendu articleVendu= new ArticleVendu (nom, description, dde, dfe, mise,0, retrait, categorie, noUtilisateur); 
			
			// On instancie un manager pour se connecter( avec la fonction Ajouter qu'on a ecrit dans ArticleVenduManager(BLL))
			ArticleVenduManager articleVenduManager = new ArticleVenduManager();
			articleVenduManager.ajouter(articleVendu);
			
			// par la suite il faudra rediriger vers la page d'accueil en mode connecté.
			RequestDispatcher rd = request.getRequestDispatcher("pages/index.jsp");
			rd.forward(request, response);
			
	}

}
