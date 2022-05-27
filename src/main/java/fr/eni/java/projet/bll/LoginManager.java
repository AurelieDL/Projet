package fr.eni.java.projet.bll;

import fr.eni.java.projet.bo.Utilisateur;
import fr.eni.java.projet.dal.DAOFactory;
import fr.eni.java.projet.dal.UtilisateurDAO;
import fr.eni.java.projet.exceptions.LoginException;

public class LoginManager {

	private UtilisateurDAO utilisateurDAO;
	
	public LoginManager()
	{
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	
	public Utilisateur Connecter(String username, String password)
	{
		return this.utilisateurDAO.selectByName(username);
		
		
		
		
	}
	public boolean checkUser(String username)
	{
		return true;
	}
	
	public Utilisateur Recuperer(String mail) 
	{
		return this.utilisateurDAO.selectByEmail(mail);
	}
}
