package fr.eni.java.projet.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.eni.java.projet.bo.Utilisateur;

class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	
	public void insert(Utilisateur utilisateur) {
		Connection cnx = null;
		
		try {
			//Connection à la BDD
			cnx = ConnectionProvider.getConnection();
			System.out.println("connecté");
			//Demande (query) en langage SQL de ce qu'on veut lui faire faire
			String query = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = cnx.prepareStatement(query);
			//Insertion des valeurs appropriées dans UtilisateurDAOJdbcImpl
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCodePostal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getMotDePasse());	
			stmt.setInt(10, 0);
			stmt.setBoolean(11, false);
			//Envoi de la demande
			
			int ret = stmt.executeUpdate();
			System.out.println("Retour SQL: nombre de lignes créées = " + ret);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				cnx.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
			System.out.println("connecté");
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
		
		try
		{

			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databasename=BDD_PROJETGROUPE", "utilisateurBDD", "Pa$$w0rd");
	             
			PreparedStatement ps = conn.prepareStatement("UPDATE utilisateurs SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=? WHERE no_utilisateur=?");
			//construction de la requête
			ps.setString(1, utilisateur.getPseudo());
			ps.setString(2, utilisateur.getNom());
			ps.setString(3, utilisateur.getPrenom());
			ps.setString(4, utilisateur.getEmail());
			ps.setString(5, utilisateur.getTelephone());
			ps.setString(6, utilisateur.getRue());
			ps.setString(7, utilisateur.getCodePostal());
			ps.setString(8, utilisateur.getVille());
			ps.setString(9, utilisateur.getMotDePasse());
			ps.setInt(10, utilisateur.getNoUtilisateur());

			ps.executeUpdate(); //execution du script SQL
			ps.close();

			System.out.println(
					"L'utilisateur " + utilisateur.getPseudo() + " a été mis à jour: " + utilisateur.toString());

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public void delete(Utilisateur utilisateur) {
	}

}
