package fr.eni.java.projet.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
       

	private int UTILISATEUR_ACTUEL_ID = 1;
	
	UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
	
	private Utilisateur getUtilisateurConnecte() {
		// Pour l'instant on utilise un utilisateur en dur
		// todo: gestion de l'utilisateur connecté
		return utilisateurDAO.selectById(UTILISATEUR_ACTUEL_ID);	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		request.setAttribute("utilisateur", getUtilisateurConnecte());
		System.out.println(getUtilisateurConnecte().toString());
        request.getRequestDispatcher("/pages/maj_profil.jsp").forward(request, response);		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//HttpSession session = request.getSession();
		//Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
		Utilisateur utilisateur = getUtilisateurConnecte();
		
        String pseudo = request.getParameter("pseudo");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String rue = request.getParameter("rue");
        String codePostal = request.getParameter("codePostal");
        String ville = request.getParameter("ville");
        String mdp = request.getParameter("mdp");
        
        
        utilisateur.setPseudo(pseudo);
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setEmail(email);
        utilisateur.setTelephone(telephone);
        utilisateur.setRue(rue);
        utilisateur.setCodePostal(codePostal);
        utilisateur.setVille(ville);
        utilisateur.setMotDePasse(mdp);

        utilisateurDAO.update(utilisateur);
	}

}
