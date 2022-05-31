package fr.eni.java.projet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



@WebServlet("/ServletConnexionPool")

public class ServletConnexionPool extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("je suis dans le DoGET");
		PrintWriter out = response.getWriter();
		try {
			Context context = new InitialContext();
			//Recherche de la DataSource
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
			
			//Demande une connexion. la méthode getConnection met en attente la demande tant qu'il n'y a pas de connections dispo dans le pool
			Connection cnx = dataSource.getConnection();
			out.print("La connexion est : " + (cnx.isClosed()?"fermée" : "ouverte") + ".");
			
			//Libérer la connexion lorsque l'on en a plus besoin
			cnx.close();//la connexion n'est pas fermée mais remise dans le Pool.
			
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			out.println("Une erreur est survenue lors de l'utilisation de la base de données : " + e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

