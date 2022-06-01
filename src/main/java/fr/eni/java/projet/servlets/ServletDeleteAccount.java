package fr.eni.java.projet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.java.projet.dal.UtilisateurDAO;

@WebServlet("/ServletDeleteAccount")
public class ServletDeleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//récupération de l'utilisateur avec son noUtilisateur
		String noUtilisateur = request.getParameter("noUtilisateur");		
		
		//converstion de la String en Int
		int id = Integer.parseInt(noUtilisateur);
		
		
		UtilisateurDAO.delete(id);
		
		request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
		
		
      //Manière "facile" de supprimer le compte je vais voir pour faire quelque chose de plus propre
		//String delete = request.getParameter("submit");
        //if(delete.equals("supprimer mon compte")) {      
        //utilisateurDAO.delete(getUtilisateurConnecte());
        
        }
//	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

}
