<%@ page import="fr.eni.java.projet.bo.Utilisateur" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <% Utilisateur user = (Utilisateur) session.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil de <%= user.getPrenom() %></title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<jsp:include page="fragments/navbar.jsp"/>

<div class="container">

	<div class="d-flex justify-content-center col-sm-12 col-lg-6 mx-auto ">
        <div class="card mt-5">
            <div class="card-body">
                <div class="row">
                <div class="col">
                	<img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="img-circle" width="150">
                 </div>   
                 <div class="col">
                 	<h4 class="card-title m-t-10"><%= user.getPseudo() %></h4>
                    <h6 class="card-subtitle"><%= user.getNom() %> <%= user.getPrenom() %></h6>    
                </div>
            </div>
            <div>
            <hr> </div>
            <div class="card-body"> 
            	<small class="text-muted">Adresse Email </small>
                <h6><%= user.getEmail() %></h6> 
                <small class="text-muted p-t-30 db">Telephone</small>
                <h6><%= user.getTelephone() %></h6> 
                <small class="text-muted p-t-30 db">Rue</small>
                <h6><%= user.getRue() %></h6>
                <small class="text-muted p-t-30 db">Code postal</small>
                <h6><%= user.getCodePostal() %></h6>
                <small class="text-muted p-t-30 db">Ville</small>
                <h6><%= user.getVille() %></h6>
            </div>
        </div>
        <a href="ServletMajProfil"><button type="button" class="btn btn-primary btn-lg mt-3">Modifier profil</button></a>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>