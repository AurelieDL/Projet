package fr.eni.java.projet.bll;

import fr.eni.java.projet.bo.ArticleVendu;
import fr.eni.java.projet.dal.ArticleDAO;
import fr.eni.java.projet.dal.DAOFactory;

public class ArticleManager {

	private ArticleDAO articleDAO;

	public ArticleManager() {
		this.articleDAO = DAOFactory.getArticleDAO();
	}

	public ArticleVendu ajouter(ArticleVendu article) {
		return null;
	}

}