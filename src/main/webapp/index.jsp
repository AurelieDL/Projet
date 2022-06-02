<%@ page import="fr.eni.java.projet.bo.ArticleVendu" %>
<%@ page import="fr.eni.java.projet.bo.Categorie" %>
<%@ page import="java.util.List"%>
<%@ page import = "fr.eni.java.projet.bo.Utilisateur" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>


<% Utilisateur user = (Utilisateur) session.getAttribute("Utilisateur"); %>
            
<jsp:include page="pages/fragments/navbar.jsp"/>

<% List<ArticleVendu> articles = (List<ArticleVendu>) request.getAttribute("articles"); %>


<section class="py-3 text-center container">
    <div class="row">
    <div class="d-flex justify-content-between align-items-center">
    	<div class="input-group w-50 mb-3">
		  <span class="input-group-text" id="basic-addon1">Mot-clés</span>
		  <input type="text" class="form-control" placeholder="Le nom de l'article contient.." aria-label="search" aria-describedby="basic-addon1"> 
		</div>
		<div>
			<p>
	          <a href="#" class="btn btn-primary btn-lg">Rechercher</a>
	        </p>
		</div>
    </div>
    </div>
    <div class="row">
	    <div class="input-group w-50 mb-3">
		    <select class="form-select" aria-label="Default select example">
			  <option selected>Catégories</option>
			  
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
	</div>
</section>

<main>
	<div class="album py-5 bg-light">
		<div class="container">
			<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3 mb-3">
	      
	      <% if (articles != null) 
	       {
	       
	       		for(ArticleVendu article: articles)
	       		{
	      %>
				        <div class="col">
				          <div class="card shadow-sm">
				            <img src="data:image/jpeg;base64,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" height="200" alt="PC GAMER">
				            <div class="card-body">
				            <h5 class="card-title"> <%= article.getNomArticle() %></h5>
				              <p class="card-text">Prix : <%= article.getMiseAPrix() %> points</p>
				              <p class="card-text">Fin de l'enchère : <%= article.getDateFinEncheres() %></p>
				              <p class="card-text">Vendeur : Jean Neymar</p>
				              <div class="d-flex justify-content-between align-items-center">
				                <small class="text-muted"><%= article.getDateDebutEncheres() %></small>
				                <div class="btn-group">
				                  <button type="button" class="btn btn-sm btn-outline-success">Enchérir</button>
				                </div>         
				              </div>
				            </div>
				          </div>
				        </div>
	     <% 	}
	       	}
	     %>  
	  	  
	 		</div>
		</div>	
	</div>
</main>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>