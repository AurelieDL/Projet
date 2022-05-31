<%@ page import= "fr.eni.java.projet.bo.Utilisateur" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% Utilisateur user = (Utilisateur) session.getAttribute("user"); %>
	
	<% if (user == null)
		{
	%>		
			<h1>Vous n'etes pas connecte</h1>
			<a href="Login"><input type="button" value= "Se connecter"></a>
		
	<%	}else
		{
		%>
	
			<h1>Bienvenue <%= user.getPseudo() %></h1>
			<a href="Disconnect"><input type="button" value= "Se deconnecter"></a>
	<%	} %>

</body>
</html>