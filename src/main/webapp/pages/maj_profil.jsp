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

<header class="header">
	<nav class="navbar">
		<div class="container">
			<a href="#" class="navbar-brand text-uppercase font-weight-bold">ENI-ENCHERES</a>
		</div>
	</nav>
</header>
<body>
	<div class="container">
		<h2 class="mb-5" style="text-align: center">Mon Profil</h2>


		<form class="shadow p-3 mb-5 bg-body rounded" action="${pageContext.request.contextPath}/ServletMajProfil"
			method="post">

			<div class="row">
				<div class="col">
					<label class="fw-bold" for="maj-pseudo">Pseudo: </label> <input type="text"
						name="pseudo" class="form-control"
						placeholder="${utilisateur.pseudo}" value="${utilisateur.pseudo}"
						required>
				</div>

				<div class="col">
					<label class="fw-bold" for="maj-email">Email:</label> <input type="text"
						name="email" class="form-control"
						placeholder="${utilisateur.email}" value="${utilisateur.email}"
						required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="fw-bold" for="maj-nom">Nom:</label> <input type="text" name="nom"
						class="form-control" placeholder="${utilisateur.nom}"
						value="${utilisateur.nom}" required>

				</div>
				<div class="col">
					<label class="fw-bold" for="maj-prenom">Prénom:</label> <input type="text"
						name="prenom" class="form-control"
						placeholder="${utilisateur.prenom}" value="${utilisateur.prenom}"
						required>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<label class="fw-bold" for="maj-telephone">Téléphone:</label> <input type="text"
						name="telephone" class="form-control"
						placeholder="${utilisateur.telephone}"
						value="${utilisateur.telephone}" required>
				</div>

				<div class="col">
					<label class="fw-bold" for="maj-rue">Rue:</label> <input type="text" name="rue"
						class="form-control" placeholder="${utilisateur.rue}"
						value="${utilisateur.rue}" required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="fw-bold" for="maj-codePostal">Code Postal:</label> <input type="text"
						name="codePostal" class="form-control"
						placeholder="${utilisateur.codePostal}"
						value="${utilisateur.codePostal}" required>
				</div>

				<div class="col">
					<label class="fw-bold" for="maj-ville">Ville:</label> <input type="text"
						name="ville" class="form-control"
						placeholder="${utilisateur.ville}" value="${utilisateur.ville}"
						required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="fw-bold" for="mdp">Mot de passe actuel: </label> 
					<input type="password"
						name="mdp" class="form-control"
						placeholder="${utilisateur.motDePasse}"
						value="${utilisateur.motDePasse}">
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
				</div>
			</div>
			<div style="text-align: center; padding-top: 20px;">
				<input type="submit" name="submit" class="btn btn-primary"
					value="Enregistrer" /> 
					<input type="submit" name="submit"
					class="btn btn-primary" value="Supprimer mon compte" />
			</div>
		</form>
	</div>
</body>
</html>