<%@ page import="fr.eni.java.projet.bo.Enchere" %>
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

<% List<Enchere> encheres = (List<Enchere>) request.getAttribute("encheres"); %>

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
			  <option value="1">Informatique</option>
			  <option value="2">Ameublement</option>
			  <option value="3">Cuisine</option>
			</select>
		</div>
	</div>
</section>

<main>
	<div class="album py-5 bg-light">
	    <div class="container">

	
	      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3 mb-3">
	      
	      <% if (encheres != null) 
	       {
	       
	       		for(Enchere enchere: encheres)
	       		{
	      %>
				        <div class="col">
				          <div class="card shadow-sm">
				            <img src="https://www.futura-sciences.com/tech/comparatifs/wp-content/uploads/2019/11/meilleur-pc-gamer.jpg" height="200" alt="PC GAMER">
				            <div class="card-body">
				            <h5 class="card-title">PC Gamer pour travailler</h5>
				              <p class="card-text">Prix : 210 points</p>
				              <p class="card-text">Fin de l'enchère : 10/06/2022</p>
				              <p class="card-text">Vendeur : Jean Neymar</p>
				              <div class="d-flex justify-content-between align-items-center">
				                <small class="text-muted">9 mins</small>
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
	  	  <div class="col">
	          <div class="card shadow-sm">
	            <img src="https://www.futura-sciences.com/tech/comparatifs/wp-content/uploads/2019/11/meilleur-pc-gamer.jpg" height="200" alt="PC GAMER">
	            <div class="card-body">
	            <h5 class="card-title">PC Gamer pour travailler</h5>
	              <p class="card-text">Prix : 210 points</p>
	              <p class="card-text">Fin de l'enchère : 10/06/2022</p>
	              <p class="card-text">Vendeur : Jean Neymar</p>
	              <div class="d-flex justify-content-between align-items-center">
	                <small class="text-muted">9 mins</small>
	                <div class="btn-group">
	                  <button type="button" class="btn btn-sm btn-outline-success">Enchérir</button>
	                </div>         
	              </div>
	            </div>
	          </div>
	        </div>
	        
			<div class="col">
	          <div class="card shadow-sm">
	            <img src="https://www.futura-sciences.com/tech/comparatifs/wp-content/uploads/2019/11/meilleur-pc-gamer.jpg" height="200" alt="PC GAMER">
	            <div class="card-body">
	            <h5 class="card-title">PC Gamer pour travailler</h5>
	              <p class="card-text">Prix : 210 points</p>
	              <p class="card-text">Fin de l'enchère : 10/06/2022</p>
	              <p class="card-text">Vendeur : Jean Neymar</p>
	              <div class="d-flex justify-content-between align-items-center">
	                <small class="text-muted">9 mins</small>
	                <div class="btn-group">
	                  <button type="button" class="btn btn-sm btn-outline-success">Enchérir</button>
	                </div>         
	              </div>
	            </div>
	          </div>
	        </div>
	
			<div class="col">
	          <div class="card shadow-sm">
	            <img src="https://www.futura-sciences.com/tech/comparatifs/wp-content/uploads/2019/11/meilleur-pc-gamer.jpg" height="200" alt="PC GAMER">
	            <div class="card-body">
	            <h5 class="card-title">PC Gamer pour travailler</h5>
	              <p class="card-text">Prix : 210 points</p>
	              <p class="card-text">Fin de l'enchère : 10/06/2022</p>
	              <p class="card-text">Vendeur : Jean Neymar</p>
	              <div class="d-flex justify-content-between align-items-center">
	                <small class="text-muted">9 mins</small>
	                <div class="btn-group">
	                  <button type="button" class="btn btn-sm btn-outline-success">Enchérir</button>
	                </div>         
	              </div>
	            </div>
	          </div>
	        </div>
	        
			<div class="col">
	          <div class="card shadow-sm">
	            <img src="https://www.futura-sciences.com/tech/comparatifs/wp-content/uploads/2019/11/meilleur-pc-gamer.jpg" height="200" alt="PC GAMER">
	            <div class="card-body">
	            <h5 class="card-title">PC Gamer pour travailler</h5>
	              <p class="card-text">Prix : 210 points</p>
	              <p class="card-text">Fin de l'enchère : 10/06/2022</p>
	              <p class="card-text">Vendeur : Jean Neymar</p>
	              <div class="d-flex justify-content-between align-items-center">
	                <small class="text-muted">9 mins</small>
	                <div class="btn-group">
	                  <button type="button" class="btn btn-sm btn-outline-success">Enchérir</button>
	                </div>         
	              </div>
	            </div>
	          </div>
	        </div>
					        
			<div class="col">
	          <div class="card shadow-sm">
	            <img src="https://www.futura-sciences.com/tech/comparatifs/wp-content/uploads/2019/11/meilleur-pc-gamer.jpg" height="200" alt="PC GAMER">
	            <div class="card-body">
	            <h5 class="card-title">PC Gamer pour travailler</h5>
	              <p class="card-text">Prix : 210 points</p>
	              <p class="card-text">Fin de l'enchère : 10/06/2022</p>
	              <p class="card-text">Vendeur : Jean Neymar</p>
	              <div class="d-flex justify-content-between align-items-center">
	                <small class="text-muted">9 mins</small>
	                <div class="btn-group">
	                  <button type="button" class="btn btn-sm btn-outline-success">Enchérir</button>
	                </div>         
	              </div>
	            </div>
	          </div>
	        </div>
	        
			<div class="col">
	          <div class="card shadow-sm">
	            <img src="https://www.futura-sciences.com/tech/comparatifs/wp-content/uploads/2019/11/meilleur-pc-gamer.jpg" height="200" alt="PC GAMER">
	            <div class="card-body">
	            <h5 class="card-title">PC Gamer pour travailler</h5>
	              <p class="card-text">Prix : 210 points</p>
	              <p class="card-text">Fin de l'enchère : 10/06/2022</p>
	              <p class="card-text">Vendeur : Jean Neymar</p>
	              <div class="d-flex justify-content-between align-items-center">
	                <small class="text-muted">9 mins</small>
	                <div class="btn-group">
	                  <button type="button" class="btn btn-sm btn-outline-success">Enchérir</button>
	                </div>         
	              </div>
	            </div>
	          </div>
	        </div>
	 	</div>
	  	  
		</div>	
	</div>
</main>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

		<a href="ServletInscription"><input type="button" value= "S'inscrire"></a>
</body>
</html>