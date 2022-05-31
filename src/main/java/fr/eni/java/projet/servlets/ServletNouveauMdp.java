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

@WebServlet("/ServletNouveauMdp")
public class ServletNouveauMdp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1. récupérer les paramètres dans la JSP
		String mdp = request.getParameter("mdp");
		String newMdp = request.getParameter("new-mdp");
		String confMdp = request.getParameter("conf-mdp");
		HttpSession session = request.getSession();
		String currentMdp = (String)session.getAttribute("mdp");
		String pseudo = (String)session.getAttribute("pseudo");
		
		if(mdp.equals(null) ||  mdp == "" || newMdp.equals(null) || newMdp == "" || confMdp.equals(null) || confMdp == "")
		{
			request.setAttribute("msg", "Tous les champs doivent être remplis");
			getServletContext().getRequestDispatcher("/maj_profil.jsp").forward(request, response);
		}
		else if(! newMdp.equals(confMdp))
		{
			request.setAttribute("msg", "Les mots de passe ne sont pas identiques");
			getServletContext().getRequestDispatcher("/maj_profil.jsp").forward(request, response);
		}
		else if (! currentMdp.equals(mdp))
		{
			request.setAttribute("msg", "Le mot de passe actuel est incorrect");
			getServletContext().getRequestDispatcher("/maj_profil.jsp").forward(request, response);
		}
		else
		{

			
		}
	}

}