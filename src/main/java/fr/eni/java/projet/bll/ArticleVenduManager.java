package fr.eni.java.projet.bll;

import java.util.List;

import fr.eni.java.projet.bo.ArticleVendu;
import fr.eni.java.projet.bo.Categorie;
import fr.eni.java.projet.dal.ArticleVenduDAO;
import fr.eni.java.projet.dal.DAOFactory;

public class ArticleVenduManager {

	private ArticleVenduDAO articleVenduDAO;
	
	
	public ArticleVenduManager()
	{
		this.articleVenduDAO = DAOFactory.getArticleVenduDAO();
	}
	
	
	public List<ArticleVendu> recupererArticlesEncours()
	{
		List<ArticleVendu> articles = null;
		
		return this.articleVenduDAO.selectAll();
	}
	
	public List<Categorie> recupererCategories()
	{
		return this.articleVenduDAO.selectAllCategories();
	}
}
