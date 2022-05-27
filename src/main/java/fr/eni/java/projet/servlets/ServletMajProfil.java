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
       

	UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
        
		Utilisateur utilisateur = utilisateurDAO.selectById(1);
	
		request.setAttribute("pseudo", "coucou");
        request.getRequestDispatcher("/WEB-INF/maj_profil.jsp").forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



	
	}

}
