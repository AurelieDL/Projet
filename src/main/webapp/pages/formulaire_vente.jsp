<%@ page import= "fr.eni.java.projet.bo.Utilisateur" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vendre un article</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<body>
	<% Utilisateur user = (Utilisateur) session.getAttribute("user"); %>

	<header class="header">
		<nav class="navbar">
			<div class="container">
				<a href="#" class="navbar-brand text-uppercase font-weight-bold">ENI-ENCHERES</a>
			</div>
		</nav>
		<div class="container col-md-4 ">
		<h1>Nouvelle vente</h1>

<form>
	<input type="hidden" name="noutilisateur" value=" <%= user.getNoUtilisateur() %>""> 
	<div class="form-group">
		<label for="nom">Article</label> <input type="text"
			class="form-control" id="nom" name="nom" placeholder="nom de l'article">
	</div>

	<div class="form-group">
		<label for="description">Description</label>
		<textarea class="form-control" id="description" name="description" rows="3"
			placeholder="Décris ton article en quelques lignes..."></textarea>
	</div>

	<div class="form-group">
		<label for="categorie">Catégorie</label> <select class="form-control"
			id="categorie" name="categorie">
			<option>Mobilier</option>
			<option>Vêtements</option>
			<option>Informatique</option>
			<option>Bricolage</option>
			<option>Services</option>
		</select>
	</div>
	<div class="form-group">
		<label for="Photo">Ajouter une photo</label> <input type="file"
			class="form-control-file" id="photo" name="photo">
	</div>

	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<label class="input-group-text" for="mise" id="mise" name="mise" >Mise à prix</label>
		</div>
		<select class="custom-select" id="listemise" name="listemise">
			<option value="1">150</option>
			<option value="2">200</option>
			<option value="3">250</option>
		</select>
	</div>

	<div>
		<label for="dde">Début de l'enchère</label> <input type="date"
			id="dde" name="dde">
	</div>
	<span class="validity"></span>

	<div>
		<label for="dfe">Fin de l'enchère</label> <input type="date" id="dfe"
			name="dfe">
	</div>
	<span class="validity"></span>

	<fieldset>
		<legend>Retrait</legend>
		<div>
			<label for="rue" Nom>Rue</label> <input type="text" id="rue" name="rue"
				placeholder="Rue" required>
		</div>
		<div>
			<label for="cp">Code postal</label> <input type="text" id="cp" name="cp"
				placeholder="Code postal">
		</div>
		<div>
			<label for="ville">Ville</label> <input type="text" id="ville" name="ville"
				placeholder="Ville">
		</div>
	</fieldset>

		    <button class="w-100 btn btn-lg btn-primary" type="submit">Enregistrer</button>
		    <button class="w-100 btn btn-lg btn-primary" type="submit">Annuler</button>
	

</form>
</div>
</body>
</html>