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
			PreparedStatement stmt = cnx.prepareStatement("INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES 	");
			
			
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
		}
		
		
	}

	@Override
	public List<Enchere> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
