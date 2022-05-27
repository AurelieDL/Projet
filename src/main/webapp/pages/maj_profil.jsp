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
	<h2 style="text-align: center">Mon Profil</h2>
	<form class="maj-profil">

		<div class="container">
			<div class="block">

				<div class="block-inner">
					<label for="maj-pseudo">Pseudo: </label> <input type="text"
						class="form-control" id="maj-pseudo" placeholder="" value=""
						required>
				</div>

				<div class="block-inner">
					<label for="maj-prenom">Prénom:</label> <input type="text"
						class="form-control" id="maj-prenom" placeholder="" value=""
						required>
				</div>

				<div class="block-inner">
					<label for="maj-telephone">Téléphone: </label> <input type="text"
						class="form-control" id="maj-telephone" placeholder="" value=""
						required>
				</div>

				<div class="block-inner">
					<label for="maj-codePostal">Code postal: </label> <input
						type="text" class="form-control" id="maj-codePostal"
						placeholder="" value="" required>
				</div>

			</div>
			<div class="block-inner">
				<label for="maj-nom">Nom: </label> <input type="text"
					class="form-control" id="maj-nom" placeholder="" value="" required>
			</div>

			<div class="block-inner">
				<label for="maj-email">Email: </label> <input type="text"
					class="form-control" id="maj-email" placeholder="" value=""
					required>
			</div>

			<div class="block-inner">
				<label for="maj-rue">Rue: </label> <input type="text"
					class="form-control" id="maj-rue" placeholder="" value="" required>
			</div>

			<div class="block-inner">
				<label for="maj-ville">Ville: </label> <input type="text"
					class="form-control" id="maj-ville" placeholder="" value=""
					required>
			</div>

			<div class="block-inner">
				<label for="mdp">Mot de passe actuel: </label> <input type="text"
					class="form-control" id="mdp" placeholder="" value="" required>
			</div>

			<div class="block-inner">
				<label for="maj-nouveauMdp">Nouveau mot de passe: </label> <input
					type="text" class="form-control" id="maj-nouveauMdp" placeholder=""
					value="" required>
			</div>

			<div class="block-inner">
				<label for="confirmation-mdp">Confirmation nouveau mot de
					passe: </label> <input type="text" class="form-control"
					id="mconfirmation-mdp" placeholder="" value="" required>
			</div>
		

		<div class="block-inner">
				<label for="credit">Crédit: </label> <input type="number" class="form-control"
					id="credit" placeholder="" value="" required>
			</div>
		<div style="text-align: center; padding-top:20px;">
			<a href="#" class="btn btn-primary" type="submit">Enregistrer</a> <a
				href="#" class="btn btn-primary" type="submit">Supprimer mon
				compte</a>
		</div>
</div>
	</form>

</body>
</html>