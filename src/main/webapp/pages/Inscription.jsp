<%@ page import="fr.eni.java.projet.exceptions.LecteurMessage" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" /> -->
    <link rel="stylesheet" href="style.css">
    <title>Inscription</title>
</head>
<header>ENI-Enchères</header>
<body>
    <h1>Inscription</h1>
    <form action="ServletInscription" method ="post">
	    <div>
	        <label for="pseudo">Pseudo :</label>
	        <input type="text" id="pseudo" name="pseudo">
	    </div>
	    <div>
	        <label for="nom">Nom :</label>
	        <input type="text" id="nom" name="nom">
	    </div>
	    <div>
	        <label for="prenom">Prénom :</label>
	        <input type="text" id="prenom" name="prenom">
	    </div>
	    <div>
	        <label for="email">Email :</label>
	        <input type="email" id="email" name="email">
	    </div>
	    <div>
	        <label for="tel">Téléphone :</label>
	        <input type="text" id="tel" name="telephone">
	    </div>
	    <div>
	        <label for="rue">Rue :</label>
	        <input type="text" id="rue" name="rue">
	    </div>
	    <div>
	        <label for="cp">Code postal :</label>
	        <input type="text" id="cp" name="codePostal">
	    </div>
	    <div>
	        <label for="ville">Ville :</label>
	        <input type="text" id="ville" name="ville">
	    </div>
    	<div>
	        <label for="mdp">Mot de passe :</label>
	        <input type="text" id="mdp" name="motDePasse">
	    </div>
	    <div>
	        <label for="conf">Confirmation :</label>
	        <input type="text" id="conf" name="conf">
	    </div>
	    <input type="submit" value="Envoyer">
	    
	    <% // Tentative de bouton retour %>
	    <input type="reset" value="Retour" href="<%=request.getContextPath() %>/accueil.html">
	    
	    <a href="<%=request.getContextPath() %>/accueil.html">Retour</a>
    </form>

    <script src="script.js"></script>
</body>
</html>