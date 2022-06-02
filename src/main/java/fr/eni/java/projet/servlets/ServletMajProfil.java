package fr.eni.java.projet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.java.projet.bo.Utilisateur;
import fr.eni.java.projet.dal.DAOFactory;
import fr.eni.java.projet.dal.UtilisateurDAO;

@WebServlet("/ServletMajProfil")
public class ServletMajProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		//On récupère la session avec l'utilisateur qui stocké dedans( celui qui s'est loggué)
		HttpSession session = request.getSession();
		
		//On récupère l'utilisateur
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
		
		request.setAttribute("utilisateur", utilisateur);
	    request.getRequestDispatcher("/pages/maj_profil.jsp").forward(request, response);	
       
        }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
		
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
			request.setAttribute("utilisateur", utilisateur.getNoUtilisateur());
			request.getRequestDispatcher("/pages/maj_profil.jsp").forward(request, response);		
        }
        //Modif mot de passe
    	if(newMdp.equals(confMdp)) {
    		if (!newMdp.equals(null) &&  newMdp != "") {
    			utilisateur.setMotDePasse(newMdp);
    	    }
    	} else {
    		String messageErreur = "* la confirmation du mot de passe doit être identique au nouveau mot de passe";
			request.setAttribute("messageErreurMdp", messageErreur);
			request.setAttribute("utilisateur", utilisateur.getNoUtilisateur());
			request.getRequestDispatcher("/pages/maj_profil.jsp").forward(request, response);			
    	}
        
  
        //renvoi l'objet utilisateur dans la fonction UPDATE de DAOjdbcImpl
        utilisateurDAO.update(utilisateur);
        session.setAttribute("user", utilisateur);
        request.getRequestDispatcher("Accueil").forward(request, response);

        }
	}

