<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "fr.eni.java.projet.bo.Utilisateur" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<header class="header">
	<nav class="navbar">
		<div class="container">
			<a href="#" class="navbar-brand text-uppercase font-weight-bold">ENI-ENCHERES</a>
		</div>
	</nav>
</header>
<body>
<% Utilisateur user = (Utilisateur) session.getAttribute("Utilisateur"); %>
	<div class="container">
		<h2 class="mb-5" style="text-align: center">Mon Profil</h2>


		<form class="shadow p-3 mb-5 bg-body rounded" action="ServletInscription"
			method="post">

			<div class="row">
				<div class="col">
					<label class="fw-bold" for="maj-pseudo">Pseudo: </label> <input type="text"
						name="pseudo" class="form-control" required>
				</div>

				<div class="col">
					<label class="fw-bold" for="maj-email">Email:</label> <input type="text"
						name="email" class="form-control" required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="fw-bold" for="maj-nom">Nom:</label> <input type="text" name="nom"
						class="form-control" required>

				</div>
				<div class="col">
					<label class="fw-bold" for="maj-prenom">Prénom:</label> <input type="text"
						name="prenom" class="form-control" required>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<label class="fw-bold" for="maj-telephone">Téléphone:</label> <input type="text"
						name="telephone" class="form-control">
				</div>

				<div class="col">
					<label class="fw-bold" for="maj-rue">Rue:</label> <input type="text" name="rue"
						class="form-control" required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="fw-bold" for="maj-codePostal">Code Postal:</label> <input type="text"
						name="codePostal" class="form-control" required>
				</div>

				<div class="col">
					<label class="fw-bold" for="maj-ville">Ville:</label> <input type="text"
						name="ville" class="form-control"
						required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="fw-bold" for="mdp">Mot de passe : </label> 
					<input type="password"
						name="motDePasse" class="form-control"
						required>
				</div>

				<div class="col">
					<label class="fw-bold" for="conf-mdp">Confirmer le mot de passe: </label> 
					<input
						type="password" name="conf" class="form-control" autocomplete="off"
						value="">
						<p>${messageErreurMdp}</p>
				</div>
			</div>
			<div style="text-align: center; padding-top: 20px;">
				<input type="submit" name="submit" class="btn btn-primary"
					value="Créer" />
			</div>
			<div style="text-align: center; padding-top: 20px;">
				<input type="reset" name="reset" class="btn btn-primary"
					value="Recommencer" />
			</div>
			<div style="text-align: center; padding-top: 20px;">
				<a class="btn btn-primary"  href="<%=request.getContextPath()%>/accueil.html" role="button">Retour</a>
			</div>
			
		</form>
		
	</div>
</body>
</html>