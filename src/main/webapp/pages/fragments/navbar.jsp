<%@ page import="fr.eni.java.projet.bo.Utilisateur"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% Utilisateur user = (Utilisateur)session.getAttribute("user"); %>
    
<header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
  <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none ms-5">
   ENI-ENCHERES
  </a>

	<% if (user != null)
		{
	%>
			  <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
			    <li><a href="#" class="nav-link px-2 link-secondary">Enchères</a></li>
			    <li><a href="#" class="nav-link px-2 link-dark">Vendre un article</a></li>
			    <li><a href="#" class="nav-link px-2 link-dark">Mon profil</a></li>
			  </ul>
			  <div class="col-md-3 text-end me-3">
			    <a href="Disconnect"><button type="button" class="btn btn-outline-primary">Se déconnecter</button></a>
			  </div>
	<% }else
		{
	%>
			  <div class="col-md-3 text-end me-3">
			    <a href="Login"><button type="button" class="btn btn-primary me-2">Se connecter</button></a>
			    <a href="ServletInscription"><button type="button" class="btn btn-outline-primary">S'inscrire</button></a>
			  </div>
  
  <% } %>
</header>