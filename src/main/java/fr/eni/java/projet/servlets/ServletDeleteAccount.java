package fr.eni.java.projet.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.java.projet.bo.Utilisateur;
import fr.eni.java.projet.dal.DAOFactory;
import fr.eni.java.projet.dal.UtilisateurDAO;

@WebServlet("/ServletDeleteAccount")
public class ServletDeleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//On récupère la session avec l'utilisateur qui stocké dedans( celui qui s'est loggué)
		HttpSession session = request.getSession();
		
		//On récupère l'utilisateur
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
		
		//On supprime l'utilisateur en se servant de son attribut NoUtilisateur
		utilisateurDAO.delete(utilisateur.getNoUtilisateur());
		
		//On efface l'utilisateur de la session en mettant null (équivaut à une déconnexion)
		session.setAttribute("user", null);
		
		//On redirige vers la page d'accueuil en mode déconnecté
		RequestDispatcher rd  = request.getRequestDispatcher("Accueil");
		rd.forward(request, response);
		
		
		
		//request.getRequestDispatcher("/Projet/index.jsp").forward(request, response);

        }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

}
