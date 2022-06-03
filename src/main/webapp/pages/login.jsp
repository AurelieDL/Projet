<%@ page import="fr.eni.java.projet.exceptions.LecteurMessage" %>
<%@ page import="fr.eni.java.projet.bll.CodesResultatBLL" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<body>
	<!--  On récupère ici, les attributs (erreurs, username, password) du doPost quand ça s'est mal passé (exceptions) -->
	<% List<Integer> erreurs = (List<Integer>) request.getAttribute("erreurs"); %>
	
	<% String username = (String) request.getAttribute("username");
		// si username = null, on met username à vide, pour eviter d'avoir NULL inscirt dans la case de saisie
		if(username == null) username = ""; %>
	<% String password = (String) request.getAttribute("password"); 
		// si password = null, on met password à vide, pour eviter d'avoir NULL inscirt dans la case de saisie
		if(password == null) password = ""; %>
	<header class="header">
		<nav class="navbar">
			<div class="container">
				<a href="Accueil" class="navbar-brand text-uppercase font-weight-bold">ENI-ENCHERES</a>
			</div>
		</nav>
	</header>
	<section class="vh-100">
		<div class="container-fluid">
			<div class="row">
				<div class="text-black d-flex justify-content-center text-center">

					<div
						class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">

						<form action="Login" method=post style="width: 23rem;">

							<h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">S'identifier</h3>

							<div class="form-outline mb-4">
								<input type="text" id="form2Example18"
									<%  
									    // On verifie bien que la liste n'est pas vide, et qu'elle contient ou le code 20000 ou le code 20001
										if((erreurs != null) && (erreurs.contains(20000) || erreurs.contains(20001))) 
										{
										
										// is-invalid met la saisie utilisateur en contour rouge
									%>
										class="form-control form-control-lg is-invalid"
									<% 
										}else
										{
									%>	class="form-control form-control-lg" 
									<%
										}
										%> name="username" value="<%= username %>"/> <label
									class="form-label" for="form2Example18">Identifiant</label>
									
									<% if(erreurs != null)
										{
											System.out.println("erreurs : " + erreurs);
											if(erreurs.contains(20000))
											{
												System.out.println("Utilisateur vide");
												//on restitue le message grâce à son code erreur
									%>
											<div id="validationServerUsernameFeedback" class="invalid-feedback">
										        <%= LecteurMessage.getMessageErreur(20000) %>
										     </div>
										<%  }
											
											if((erreurs.contains(20001)))
											{
												//on restitue le message grâce à son code erreur
										%>
												<div id="validationServerUsernameFeedback" class="invalid-feedback">
										        <%= LecteurMessage.getMessageErreur(20001) %>
										     	</div>
										<%  }
										}
									%>
							</div>

							<div class="form-outline mb-4">
								<input type="password" id="form2Example28"
									<% if((erreurs != null) && (erreurs.contains(20002) || erreurs.contains(20003))) 
										{  
									%>
										class="form-control form-control-lg is-invalid"
									<% 
										}else
										{
									%>	class="form-control form-control-lg" 
									<%
										}
										%> name="password" value="<%= password %>" /> <label
									class="form-label" for="form2Example28">Mot de passe</label>
									<% if(erreurs != null)
										{
											if((erreurs.contains(CodesResultatBLL.REGLE_LOGIN_PASSWORD_NULL_ERREUR)))
											{
									%>
											<div id="validationServerUsernameFeedback" class="invalid-feedback">
										        <%= LecteurMessage.getMessageErreur(CodesResultatBLL.REGLE_LOGIN_PASSWORD_NULL_ERREUR) %>
										     </div>
										<%  }
											
											if((erreurs.contains(CodesResultatBLL.REGLE_LOGIN_PASSWORD_WRONG_ERREUR)))
											{
										%>
												<div id="validationServerUsernameFeedback" class="invalid-feedback">
										        <%= LecteurMessage.getMessageErreur(CodesResultatBLL.REGLE_LOGIN_PASSWORD_WRONG_ERREUR) %>
										     	</div>
										<%  }
										}
									%>
							</div>

							<div class="pt-1 mb-4">
								<button class="btn btn-info btn-lg btn-block" type="submit">Se connecter</button>
							</div>

							<p class="small mb-5 pb-lg-2">
								<a class="text-muted" href="ForgotPassword">Mot de passe oublié</a>
							</p>
							<p>
								Pas de compte? <a href="ServletInscription" class="link-info">En créer un ici!</a>
							</p>

						</form>

					</div>

				</div>

			</div>
		</div>
	</section>
</body>
</html>