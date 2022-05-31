package fr.eni.java.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import fr.eni.java.projet.bo.Utilisateur;

class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	public void insert(Utilisateur utilisateur) {

	}

	public Utilisateur selectById(int noUtilisateur) {
		return null;
	}

	public Utilisateur selectByName(String name) {
		Utilisateur user = null;
		Connection cnx = null;

		try {
			cnx = ConnectionProvider.getConnection();
			System.out.println("connected");
			
			PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM UTILISATEURS WHERE nom = ?");
			
			stmt.setString(1, name);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				user = new Utilisateur();
				user.setNoUtilisateur(rs.getInt(1));
				user.setPseudo(rs.getString(2));
				user.setNom(rs.getString(3));
				user.setPrenom(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setTelephone(rs.getString(6));
				user.setRue(rs.getString(7));
				user.setCodePostal(rs.getString(8));
				user.setVille(rs.getString(9));
				user.setMotDePasse(rs.getString(10));
				user.setCredit(rs.getInt(11));
				user.setAdministrateur(rs.getBoolean(12));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				cnx.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	public Utilisateur selectByEmail(String email)
	{
		Utilisateur user = null;
		Connection cnx = null;
		
		try
		{
			cnx= ConnectionProvider.getConnection();
			System.out.println("connected");
			PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM UTILISATEURS WHERE email = ?");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
			{
				user = new Utilisateur();
				
				user.setPseudo(rs.getString(2));
				user.setNom(rs.getString(3));
				user.setPrenom(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setTelephone(rs.getString(6));
				user.setRue(rs.getString(7));
				user.setCodePostal(rs.getString(8));
				user.setVille(rs.getString(9));
				user.setMotDePasse(rs.getString(10));
				user.setCredit(rs.getInt(11));
				user.setAdministrateur(rs.getBoolean(12));
				
				
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}

	public List<Utilisateur> selectAll() {
		return null;
	}

	public void update(Utilisateur utilisateur) {

	}

	public void delete(Utilisateur utilisateur) {

	}
}
