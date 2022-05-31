package fr.eni.java.projet.dal;

import java.util.Date;
import java.util.List;

import fr.eni.java.projet.bo.ArticleVendu;

public interface ArticleVenduDAO {

	public void insert(ArticleVendu articleVendu);
	
	//Il faut pouvoir mettre à jour
	public void update(ArticleVendu articleVendu);

	public void delete(ArticleVendu articleVendu);
	
	public ArticleVendu selectById(int noArticle);
	
	//Pour ne prendre que les enchères en cours, pour dateFinEncheres < getDate()
	public ArticleVendu selectByDate(Date dateFinEncheres);

	// Un selectByCategorie en le mettant en clé étrangère ça serait sûrement bien, peut-être plus tard, je sais pas comment m'y prendre	
	
	public List<ArticleVendu> selectAll();
}
