<%@ page import = "fr.eni.java.projet.bo.Utilisateur" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Utilisateur user = (Utilisateur) session.getAttribute("Utilisateur"); %>
<% if (user == null) { %>
<jsp:forward page="Login"></jsp:forward>
	<% } %>
	<h1>Bienvenue <%= user.getPseudo().toUpperCase() %></h1>
		<a href="Login"><input type="button" value= "Se connecter"></a>
		<a href="ServletInscription"><input type="button" value= "S'inscrire"></a>
</body>
</html>