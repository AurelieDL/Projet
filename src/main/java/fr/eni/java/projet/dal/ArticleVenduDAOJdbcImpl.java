package fr.eni.java.projet.dal;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {
	
	public void insert(ArticleVendu articleVendu);
	
	public void selectById(int noArticle): ArticleVendu;

	public void selectAll(): List<ArticleVendu>;

	public void update(ArticleVendu articleVendu);

	public void delete(ArticleVendu articleVendu);
}
