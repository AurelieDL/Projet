<%@ page import= "fr.eni.java.projet.bo.Utilisateur" %>
<%@ page import= "fr.eni.java.projet.bo.Categorie" %>
<%@ page import= "java.util.List" %>
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


<jsp:include page="fragments/navbar.jsp"/>

<div class="container col-md-6 ">
	<h2 class="mb-2" style="text-align: center">Nouvelle vente</h2>

	<form class="shadow p-3 mb-5 bg-body rounded" >
	<input type="hidden" name="noutilisateur" value=" <%= user.getNoUtilisateur() %>""> 
	<div class="row col-lg-12">
	
		<div class="col-lg-6">
			
			<div class="form-group">
				<label for="nom">Article</label> <input type="text"
					class="form-control" id="nom" name="nom" placeholder="nom de l'article">
			</div>
		
			<div class="form-group">
				<label for="description">Description</label>
				<textarea class="form-control" id="description" name="description" rows="3"
					placeholder="Décris ton article en quelques lignes..."></textarea>
			</div>
		
			<div class="form-group mb-3">
				<label for="categorie">Catégorie</label> <select class="form-control"
					id="categorie" name="categorie">
					<% List<Categorie> categories = (List<Categorie>) request.getAttribute("categories"); 
					if(categories != null)
					{
						for(Categorie categorie:categories)
						{
				%>
							<option value=" <%= categorie.getNoCategorie() %>" > <%= categorie.getLibelle() %></option>
				<%
						}
					}
				%>
				</select>
			</div>
			
			<div class="form-group mb-3">
				<label for="photo">Ajouter une photo</label> 
				<input type="file" class="form-control-file" id="photo" name="photo">
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
	
			<div class="row">
				<div class="col">
					<label for="dde">Début de l'enchère</label> <input type="date"
						id="dde" name="dde">
				<span class="validity"></span>
				</div>
				<div class="col">
					<label for="dfe">Fin de l'enchère</label> <input type="date" id="dfe"
						name="dfe">
				</div>
				<span class="validity"></span>
			</div>
			
		</div>
		
		
		<div class="col-lg-5 ms-5">
		
			<fieldset>
				<legend>Retrait</legend>
				<div>
				<div class="row mb-1">
					<div class="col-lg-3"><label for="rue">Rue</label></div>
					<div class="col-lg-9"><input type="text" id="rue" name="rue" placeholder="Rue" required></div>
				</div>
				<div class="row mb-1">
					<div class="col-lg-3"><label for="cp">Code postal</label></div>
					<div class="col-lg-9"><input type="text" id="cp" name="cp" placeholder="Code postal"></div>
				</div>
				<div class="row mb-1">
					<div class="col-lg-3"><label for="ville">Ville</label></div>
					<div class="col-lg-9"><input type="text" id="ville" name="ville" placeholder="Ville"></div>
				</div>
				</div>
			</fieldset>
		
			<hr>
		
			<img src="data:image/jpeg;base64,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" class="rounded mx-auto d-block" alt="Aucune photo ajoutée">
		</div>
	</div>
	<hr>
	<div class="row mt-3 d-flex align-items-end">
		<div class="col">
		    <button class="w-100 btn btn-lg btn-primary" type="submit">Enregistrer</button>
		</div>    
		<div class="col">
			<button class="w-100 btn btn-lg btn-outline-primary" type="submit">Annuler</button>
		</div>
	</div>
	</form>
</div>

</body>
</html>