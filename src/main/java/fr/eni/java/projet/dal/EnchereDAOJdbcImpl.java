package fr.eni.java.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import fr.eni.java.projet.bo.Enchere;

class EnchereDAOJdbcImpl implements EnchereDAO {
	
	@Override
	public void insert(Enchere enchere) {
		Connection cnx = null;
		
		try {
			cnx = ConnectionProvider.getConnection();
			System.out.println("connected");
			PreparedStatement stmt = cnx.prepareStatement("INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES 	(?,?,?,?)");
			
			
			stmt.setInt(1, enchere.getNoUtilisateur());
			stmt.setInt(2, enchere.getNoArticle());
			stmt.setDate(3,(java.sql.Date) enchere.getDateEnchere());
			stmt.setInt(4, enchere.getMontant_enchere());
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
			}
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try {
				cnx.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Enchere> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
