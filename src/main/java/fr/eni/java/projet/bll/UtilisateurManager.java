package fr.eni.java.projet.bll;

import fr.eni.java.projet.bo.Utilisateur;
import fr.eni.java.projet.dal.DAOFactory;
import fr.eni.java.projet.dal.UtilisateurDAO;
import fr.eni.java.projet.exceptions.LoginException;

puhttps://github.com/AurelieDL/Projet/pull/8/conflict?name=src%252Fmain%252Fjava%252Ffr%252Feni%252Fjava%252Fprojet%252Fbll%252FUtilisateurManager.java&ancestor_oid=525aca22a8f3937657595660d54d0c983604e4ac&base_oid=a9a18298b492f01fc8398406c6a21f706069c7f5&head_oid=d642fd547a91e0606653baba835817cd017316fablic class UtilisateurManager {

	private UtilisateurDAO utilisateurDAO;

	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}

	public Utilisateur Connecter(String username, String password) {

		return this.utilisateurDAO.selectByName(username);

	}

	public boolean checkUser(String username) {
		return true;
	}

	public Utilisateur Recuperer(String mail) {
		return this.utilisateurDAO.selectByEmail(mail);
	}

	
	public Utilisateur Créer(Utilisateur utilisateur)
	{
		
		// CONTRAINTES A AJOUTER
		// Pseudo et e-mail doivent être uniques sur toute la plate-forme (check dans la base de données, par un try catch ou un if je sais pas)
		// Le pseudo n'accepte que les caractères alpha-numériques (je dirais de chercher si les caractères se situent entre 0 et 9 ou entre a et z, sûrement en les traitant comme des arrays avec des crochets là, vous savez
		// ICI OU DANS DAOJdbcImpl ??? Le crédit initial est de 0 - Fait dans JdbcImpl pour l'instant
		this.utilisateurDAO.insert(utilisateur);
		return utilisateur;

	}
}
