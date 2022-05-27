<%@ page import="fr.eni.java.projet.bo.Utilisateur"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil</title>
</head>
<body>
	<% Utilisateur user = (Utilisateur)request.getAttribute("Utilisateur"); %>
		<h1>Profil de <%= user.getPseudo()  %></h1>
</body>
</html>