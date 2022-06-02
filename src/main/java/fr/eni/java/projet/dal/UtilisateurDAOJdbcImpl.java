package fr.eni.java.projet.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.java.projet.bo.Utilisateur;
import fr.eni.java.projet.exceptions.BusinessException;

class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	public void insert(Utilisateur utilisateur) {
		Connection cnx = null;

		try {

			// Connection à la BDD
			cnx = ConnectionProvider.getConnection();
			System.out.println("connecté");
			// Demande (query) en langage SQL de ce qu'on veut lui faire faire
			String query = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

//			PreparedStatement pstmt = cnx.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			PreparedStatement pstmt = cnx.prepareStatement(query);
			//Insertion des valeurs appropriées dans UtilisateurDAOJdbcImpl
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());	
			pstmt.setInt(10, 0);
			pstmt.setBoolean(11, false);
			//Envoi de la demande
			
			int ret = pstmt.executeUpdate();
			System.out.println("Retour SQL: nombre de lignes créées = " + ret);
			// On fait la gymnastique commencée dans le PreparedStatement pour récupérer l'id utilisateur
//			ResultSet rs = pstmt.getGeneratedKeys();
//			if (rs.next()) {
//				utilisateur.setNoUtilisateur(rs.getInt(1));
//			}
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
		Utilisateur user = null;
		Connection cnx = null;

		try {
			cnx = ConnectionProvider.getConnection();
			System.out.println("connected");

			PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?");

			stmt.setInt(1, noUtilisateur);

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

	public Utilisateur selectByEmail(String email) {
		Utilisateur user = null;
		Connection cnx = null;

		try {
			cnx = ConnectionProvider.getConnection();
			System.out.println("connecté");
			PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM UTILISATEURS WHERE email = ?");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
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

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<Utilisateur> selectAll() {
		return null;
	}

	public void update(Utilisateur utilisateur) {
		
			try {

			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databasename=BDD_PROJETGROUPE",
					"utilisateurBDD", "Pa$$w0rd");

			PreparedStatement ps = conn.prepareStatement(
					"UPDATE utilisateurs SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=? WHERE no_utilisateur=?");
			// construction de la requête
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

			ps.executeUpdate(); // execution du script SQL
			ps.close(); // fermeture PreparedStatement
			conn.close();// fermeture Connection

			System.out.println(
					"L'utilisateur " + utilisateur.getPseudo() + " a été mis à jour: " + utilisateur.toString());

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	
	public void delete(int noUtilisateur) {
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databasename=BDD_PROJETGROUPE",
					"utilisateurBDD", "Pa$$w0rd");
			
			String query = "DELETE FROM utilisateurs WHERE no_utilisateur=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, noUtilisateur);
			
			ps.executeUpdate(); // execution du script SQL
			
			System.out.println("Suppression ok");
			ps.close(); // fermeture PreparedStatement
			conn.close();// fermeture Connection

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
/*
	@Override
	public boolean checkPseudoUnique(String pseudo){
		Connection cnx;
		try {
			cnx = ConnectionProvider.getConnection();
			System.out.println("connecté");
			String query = "SELECT COUNT(*) FROM UTILISATEURS WHERE pseudo = ?;";
			
			PreparedStatement pstmt = cnx.prepareStatement(query);
			pstmt.setString(1, pseudo);
			boolean presence = pstmt.execute();
			if (presence = true) {
				//changer le booléen, je ne sais plus comment
				return true;
			} else {
				// Dans le catch peut-être ? Renvoyer un truc du style REGLE_INSCRIPTION_PSEUDO_UNIQUE_ERREUR
				return false;
			}
					
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		return false;
	}
*/
}
