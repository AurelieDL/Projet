package fr.eni.java.projet.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.java.projet.bll.UtilisateurManager;
import fr.eni.java.projet.bo.Utilisateur;


@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ForgotPassword() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("pages/oubliMdp.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("mail");
		UtilisateurManager utilisateurManager= new UtilisateurManager();
		Utilisateur user2 = utilisateurManager.Recuperer(email);
		request.setAttribute("user", user2);
		RequestDispatcher rd = request.getRequestDispatcher("pages/emailSent.jsp");
		rd.forward(request, response);
		
	}

}
