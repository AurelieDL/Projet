package fr.eni.java.projet.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.eni.java.projet.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	private static final String UPDATE = "UPDATE utilisateurs SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, codePostal=?, ville=?, motDePasse=? WHERE id=?";
	
	@Override
	public void insert(Utilisateur utilisateur) {

	}

	private static final String SELECT = "SELECT * FROM utilisateurs WHERE no_utilisateur=";
	
	@Override
	public Utilisateur selectById(int noUtilisateur) {
		
		// Utilisateur utilisateur = 
		
		String query = this.SELECT + String.valueOf(noUtilisateur);
		
		try {
			Statement statement = getConnection().createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			if (rs.next()) {

				System.out.print(rs.getString(1));
				System.out.print(rs.getString(2));
			}
			
			

			return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
		
	}

	@Override
	public List<Utilisateur> selectAll() {
		return null;
	}

	@Override
	public void update(Utilisateur utilisateur) {
		try (Connection conn = DriverManager.getConnection(
                "jdbc:sqlserver://localhost;databasename=BDD_PROJETGROUPE", "utilisateurBDD", "Pa$$w0rd");
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE))
		{

			PreparedStatement ps = conn.prepareStatement(UPDATE);

			ps.setString(1, utilisateur.getPseudo());
			ps.setString(2, utilisateur.getNom());
			ps.setString(3, utilisateur.getPrenom());
			ps.setString(4, utilisateur.getEmail());
			ps.setString(5, utilisateur.getTelephone());
			ps.setString(6, utilisateur.getRue());
			ps.setString(7, utilisateur.getCodePostal());
			ps.setString(8, utilisateur.getVille());
			ps.setString(9, utilisateur.getMotDePasse());

			ps.executeUpdate();
			ps.close();

			System.out.println(
					"L'utilisateur " + utilisateur.getPseudo() + " a été mis à jour: " + utilisateur.toString());

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public void delete(Utilisateur utilisateur) {

	}
	
	private Connection getConnectionautre() {
		try {
			return DriverManager.getConnection(
			        "jdbc:sqlserver://localhost;databasename=BDD_PROJETGROUPE", "utilisateurBDD", "Pa$$w0rd");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private Connection getConnection() {

		try {
			return ConnectionProvider.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
