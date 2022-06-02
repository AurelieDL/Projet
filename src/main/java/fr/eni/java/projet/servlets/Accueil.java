package fr.eni.java.projet.servlets;

import java.io.IOException;
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


@WebServlet("/")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArticleVenduManager articleVenduManager = new ArticleVenduManager();
		
		List<ArticleVendu> articles = articleVenduManager.recupererArticlesEncours();
		List<Categorie> categories = articleVenduManager.recupererCategories();
		
		request.setAttribute("articles", articles);
		request.setAttribute("categories", categories);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
