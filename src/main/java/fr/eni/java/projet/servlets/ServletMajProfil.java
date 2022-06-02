package fr.eni.java.projet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.java.projet.bo.Utilisateur;
import fr.eni.java.projet.dal.DAOFactory;
import fr.eni.java.projet.dal.UtilisateurDAO;

@WebServlet("/ServletMajProfil")
public class ServletMajProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private int UTILISATEUR_ACTUEL_ID = 7;
	
	UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
	
	private Utilisateur getUtilisateurConnecte() {
		// Pour l'instant on utilise un utilisateur en dur
		return utilisateurDAO.selectById(UTILISATEUR_ACTUEL_ID);	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		request.setAttribute("utilisateur", getUtilisateurConnecte());
	//	System.out.println(getUtilisateurConnecte().toString());
        request.getRequestDispatcher("/pages/maj_profil.jsp").forward(request, response);	
        
   
        String noUtilisateur = request.getParameter("noUtilisateur");		

        }
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//HttpSession session = request.getSession();
		//Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
		//Utilisateur utilisateur = getUtilisateurConnecte();

		
		//Déclaration de variables - récupération des infos du formulaire transmises via la requête POST
        String pseudo = request.getParameter("pseudo");	
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String rue = request.getParameter("rue");
        String codePostal = request.getParameter("codePostal");
        String ville = request.getParameter("ville");
        String mdp = request.getParameter("mdp");
        String newMdp = request.getParameter("new-mdp");
        String confMdp = request.getParameter("conf-mdp");        
            
        //récupération de l'utilisateur
      	Utilisateur utilisateur = getUtilisateurConnecte();
      	
        //On remplace les variables de l'utilisateur par les infos du formulaire
        utilisateur.setPseudo(pseudo);       
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setEmail(email);
        utilisateur.setTelephone(telephone);
        utilisateur.setRue(rue);
        utilisateur.setCodePostal(codePostal);
        utilisateur.setVille(ville);
       
        if(!mdp.equals(utilisateur.getMotDePasse())) {
    		String messageErreur = "Votre mot de passe actuel est incorrect";
			request.setAttribute("messageErreurMdpIncorrect", messageErreur);
			request.setAttribute("utilisateur", getUtilisateurConnecte());
			request.getRequestDispatcher("/pages/maj_profil.jsp").forward(request, response);		
        }
     
    	if(newMdp.equals(confMdp)) {
    		if (!newMdp.equals(null) &&  newMdp != "") {
    			utilisateur.setMotDePasse(newMdp);
    	    }
    	} else {
    		String messageErreur = "* la confirmation du mot de passe doit être identique au nouveau mot de passe";
			request.setAttribute("messageErreurMdp", messageErreur);
			request.setAttribute("utilisateur", getUtilisateurConnecte());
			request.getRequestDispatcher("/pages/maj_profil.jsp").forward(request, response);			
    	}
        
  
        //renvoi l'objet utilisateur dans la fonction UPDATE de DAOjdbcImpl
        utilisateurDAO.update(utilisateur);
        
        //Manière "facile" de supprimer le compte je vais voir pour faire quelque chose de plus propre
      //  if(delete.equals("supprimer mon compte")) {
        	//utilisateurDAO.delete(getUtilisateurConnecte());
        }
	}

