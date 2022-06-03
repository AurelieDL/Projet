package fr.eni.java.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.java.projet.bo.ArticleVendu;
import fr.eni.java.projet.bo.Categorie;

class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {
	
	List<ArticleVendu> articles = new ArrayList<>();
	Connection cnx = null;
	List<Categorie> categories = new ArrayList<>();
	
	@Override
	public void insert(ArticleVendu articleVendu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ArticleVendu articleVendu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ArticleVendu articleVendu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArticleVendu selectById(int noArticle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleVendu selectByDate(Date dateFinEncheres) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleVendu> selectAll() {
		
		try
		{		
			cnx = ConnectionProvider.getConnection();
			
			PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM ARTICLES_VENDUS");
			ResultSet rs = stmt.executeQuery();
			//System.out.println(rs);
			while(rs.next())
			{
				ArticleVendu article = new ArticleVendu();
				
				article.setNoArticle(rs.getInt(1));
				article.setNomArticle(rs.getString(2));
				article.setDescription(rs.getString(3));
				article.setDateDebutEncheres(rs.getDate(4));
				article.setDateFinEncheres(rs.getDate(5));
				article.setMiseAPrix(rs.getInt(6));
				article.setPrixVente(rs.getInt(7));
				article.setNoUtilisateur(rs.getInt(8));
				article.setNoCategorie(rs.getInt(9));
				
				
				articles.add(article);
				//System.out.println(article.toString());
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try
			{
				cnx.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return articles;
	}
	
	public List<Categorie> selectAllCategories()
	{
		
		try
		{
			cnx = ConnectionProvider.getConnection();
			
			PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM CATEGORIES");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Categorie categorie = new Categorie();
				
				categorie.setNoCategorie(rs.getInt(1));
				categorie.setLibelle(rs.getString(2));
				
				//System.out.println(categorie.toString());
				
				categories.add(categorie);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try
			{
				cnx.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return categories;
	}
}
