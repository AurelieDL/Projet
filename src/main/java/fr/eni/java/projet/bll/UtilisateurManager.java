package fr.eni.java.projet.bll;

import java.sql.SQLException;

import fr.eni.java.projet.bo.Utilisateur;
import fr.eni.java.projet.dal.DAOFactory;
import fr.eni.java.projet.dal.UtilisateurDAO;
import fr.eni.java.projet.exceptions.BusinessException;


public class UtilisateurManager 
{

	private UtilisateurDAO utilisateurDAO;
	
	// Appeler UtilisateurManager instanciera un nouvel UtilisateurDAOJdbcImpl
	public UtilisateurManager()
	{
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	
	public Utilisateur Connecter(String username, String password) throws BusinessException
	{
		BusinessException exception = new BusinessException();
		
		Utilisateur user;
		try {
			// on verifie d'abord si l'username existe et que le username n'est pas vide,
			// sinon on rempli la listes des exception 
			user = checkUser(username, exception);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		//arrivé ici, l'utilisateur existe, donc on verifie le mot de passe
		if(user!= null) checkPassword(password, user, exception);
		
		if(exception.hasErreurs())
		{
			// on renvoie la liste d'erreurs dans une exception (on va pas jusquau return du coup)
			throw exception;
		}
		
		//si tout s'est bien passé, on renvoie l'utilisateur
		return user;		
	}
		
	public Utilisateur checkUser(String username, BusinessException exception) throws SQLException
	{
		Utilisateur user = null;
		
		if(username.equals("") || username == null) // cf ajout avis
		{
			// On ajoute une erreur dans la liste des erreurs qui seront remontées sur la JSP
			exception.ajouterErreur(CodesResultatBLL.REGLE_LOGIN_USERNAME_NULL_ERREUR);
		}else
		{
			try
			{
			user = this.utilisateurDAO.selectByName(username);
			if (user == null)
			{
				// On ajoute une erreur dans la liste des erreurs qui seront remontées sur la JSP
				exception.ajouterErreur(CodesResultatBLL.REGLE_LOGIN_USERNAME_NOT_EXIST_ERREUR);
			}
			}catch(NullPointerException e)
			{
				// On ajoute une erreur dans la liste des erreurs qui seront remontées sur la JSP
				exception.ajouterErreur(CodesResultatBLL.REGLE_LOGIN_USERNAME_NOT_EXIST_ERREUR);
			}
		}
		
		return user;
	}
	
	public void checkPassword(String password, Utilisateur user, BusinessException exception) {
		
		if(password.equals("") || password == null)
		{
			exception.ajouterErreur(CodesResultatBLL.REGLE_LOGIN_PASSWORD_NULL_ERREUR);
		}else
		{
		
			if(password.compareTo(user.getMotDePasse()) != 0)
			{
				exception.ajouterErreur(CodesResultatBLL.REGLE_LOGIN_PASSWORD_WRONG_ERREUR);
			}
		}
		
	}
	
	public Utilisateur Recuperer(String mail) throws SQLException 
	{
		Utilisateur user = null;
		
		try {	 
				user = this.utilisateurDAO.selectByEmail(mail);
		}catch(NullPointerException e)
		{
			return null;
		}
		
		return user;
	}

	public Utilisateur Créer(Utilisateur utilisateur) {
/*
		BusinessException exception = new BusinessException();
		
		//On appelle les méthodes qui s'assurent que la saisie est réglementaire. Ces méthodes sont définies ci-après.
		this.checkPseudoUnique(utilisateur.getPseudo(), exception);
		this.checkEmailUnique(utilisateur.getEmail(), exception);
		this.checkPseudoAlphanumerique(utilisateur.getPseudo(), exception);
		this.checkTelephoneNumerique(utilisateur.getTelephone(), exception);
		
		if (!exception.hasErreurs()) {
*/			this.utilisateurDAO.insert(utilisateur);
//		} else {
//		}
		return utilisateur;
	}

/*
	private void checkPseudoAlphanumerique(String pseudo, BusinessException exception) {
		// Vérifier que le pseudo n'accepte que les caractères alpha-numériques
		if (pseudo.matches("[a-zA-Z0-9]+")) {
			}	else	{
				exception.ajouterErreur(CodesResultatBLL.REGLE_INSCRIPTION_PSEUDO_ALPHANUMERIQUE_ERREUR);
			}
	}
	
	
	private void checkTelephoneNumerique(String telephone, BusinessException exception) {
		// (Bonus) Vérifier que le numéro de téléphone ne comporte bien que des chiffres
		if (telephone.matches("[0-9]")) {
		}	else	{
			exception.ajouterErreur(CodesResultatBLL.REGLE_INSCRIPTION_TELEPHONE_NUMERIQUE_ERREUR);
		}
	}
	
	
	private void checkPseudoUnique(String pseudo, BusinessException exception) {
		// Vérifier que le pseudo est unique sur toute la plate-forme
		try {
			this.utilisateurDAO.checkPseudoUnique(pseudo);
		} catch (BusinessException ex) {
			exception.ajouterErreur(CodesResultatBLL.REGLE_INSCRIPTION_PSEUDO_UNIQUE_ERREUR);
			ex.printStackTrace();
		}
			if (true) {
				//renvoyer une erreur
		}
	}
	
	
	private void checkEmailUnique(String email, BusinessException exception) {
		// Vérifier que l'email est unique sur toute la plate-forme
		// Comme pour PseudoUnique en mettant email en paramètre à la place
	}
	
	*/
}
