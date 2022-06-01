package fr.eni.java.projet.bll;

import fr.eni.java.projet.bo.Utilisateur;
import fr.eni.java.projet.dal.DAOFactory;
import fr.eni.java.projet.dal.UtilisateurDAO;
import fr.eni.java.projet.exceptions.LoginException;


public class UtilisateurManager 
{

	private UtilisateurDAO utilisateurDAO;
	
	public UtilisateurManager()
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

	public Utilisateur Créer(Utilisateur utilisateur) {


		// CONTRAINTES A AJOUTER
		// Pseudo et e-mail doivent être uniques sur toute la plate-forme (check dans la
		// base de données, par un try catch ou un if je sais pas)
		// Le pseudo n'accepte que les caractères alpha-numériques (je dirais de
		// chercher si les caractères se situent entre 0 et 9 ou entre a et z, sûrement
		// en les traitant comme des arrays avec des crochets là, vous savez)
		this.utilisateurDAO.insert(utilisateur);
		return utilisateur;

	}
	

}
