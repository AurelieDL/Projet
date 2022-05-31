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
	private static final String UPDATE = "UPDATE utilisateurs SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=? WHERE no_utilisateur=?";
	
	@Override
	public void insert(Utilisateur utilisateur) {

	}
	
	

	private static final String SELECT = "SELECT * FROM utilisateurs WHERE no_utilisateur=";
	
	@Override
	public Utilisateur selectById(int noUtilisateur) {
		
		
		String query = this.SELECT + String.valueOf(noUtilisateur);
		
		try {
			Statement statement = getConnection().createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			if (rs.next()) {

				Utilisateur utilisateur = new Utilisateur(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getInt(11),
						rs.getBoolean(12)
						);

				return utilisateur;

			}
			
			return new Utilisateur();
			
				
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
		
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
			ps.setInt(10, utilisateur.getNoUtilisateur());

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
