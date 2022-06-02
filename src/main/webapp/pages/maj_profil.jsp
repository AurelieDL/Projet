<%@ page import="fr.eni.java.projet.bo.Utilisateur"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon profil</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">

<jsp:include page="fragments/navbar.jsp"/>
<body>
	<div class="container">
		<h2 class="mb-5" style="text-align: center">Mon Profil</h2>
<% Utilisateur utilisateur = (Utilisateur)session.getAttribute("user"); %>

		<form class="shadow p-3 mb-5 bg-body rounded" action="${pageContext.request.contextPath}/ServletMajProfil"
			method="post">

			<div class="row">
				<div class="col">
					<label class="fw-bold" for="maj-pseudo">Pseudo: </label> <input type="text"
						name="pseudo" class="form-control"
						placeholder="${user.pseudo}" value="${user.pseudo}"
						required>
				</div>

				<div class="col">
					<label class="fw-bold" for="maj-email">Email:</label> <input type="text"
						name="email" class="form-control"
						placeholder="${user.email}" value="${user.email}"
						required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="fw-bold" for="maj-nom">Nom:</label> <input type="text" name="nom"
						class="form-control" placeholder="${user.nom}"
						value="${user.nom}" required>

				</div>
				<div class="col">
					<label class="fw-bold" for="maj-prenom">Prénom:</label> <input type="text"
						name="prenom" class="form-control"
						placeholder="${user.prenom}" value="${user.prenom}"
						required>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<label class="fw-bold" for="maj-telephone">Téléphone:</label> <input type="text"
						name="telephone" class="form-control"
						placeholder="${user.telephone}"
						value="${user.telephone}" >
				</div>

				<div class="col">
					<label class="fw-bold" for="maj-rue">Rue:</label> <input type="text" name="rue"
						class="form-control" placeholder="${user.rue}"
						value="${user.rue}" required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="fw-bold" for="maj-codePostal">Code Postal:</label> <input type="text"
						name="codePostal" class="form-control"
						placeholder="${user.codePostal}"
						value="${user.codePostal}" required>
				</div>

				<div class="col">
					<label class="fw-bold" for="maj-ville">Ville:</label> <input type="text"
						name="ville" class="form-control"
						placeholder="${user.ville}" value="${user.ville}"
						required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="fw-bold" for="mdp">Mot de passe actuel: </label> 
					<input type="password"
						name="mdp" class="form-control"
						placeholder="${user.motDePasse}"
						value="${user.motDePasse}">
						<p>${messageErreurMdpIncorrect }</p>
				</div>

				<div class="col auth-pass-inputgroup">
					<label class="fw-bold" for="new-mdp">Nouveau mot de passe: </label> 
					<input
						type="password" name="new-mdp" class="form-control" placeholder=""
						value="">
				</div>

				<div class="col">
					<label class="fw-bold" for="conf-mdp">Confirmer le nouveau mot de passe: </label> 
					<input
						type="password" name="conf-mdp" class="form-control" autocomplete="off"
						value="">
						<p>${messageErreurMdp}</p>
				</div>
			</div>
			<div style="text-align: center; padding-top: 20px;">
				<input type="submit" name="submit" class="btn btn-primary"
					value="Enregistrer" />
			</div>
			
		</form>
		<div style="text-align: center; marging-top: 10px">
		<form action="${pageContext.request.contextPath}/ServletDeleteAccount"
			method="get">
			
		<input type="submit" name="delete" 
					class="btn btn-primary" value="Supprimer mon compte" />
		</form>
		</div>
	</div>
</body>
</html>