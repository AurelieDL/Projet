<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login page</h1>
	<form method="post" action="Login"> 
	<div>
		<label>Identifiant</label>
		<input type="text" name= "username">
	</div>
	<div>
		<label>Mot de passe</label>
		<input type="password" name = "password">
	</div>
	<div>
		<label>Se souvenir de moi </label>
		<input type="checkbox" name= "rememberMe">
		<a href="ForgotPassword" >Mot de passe oublié?</a>
	</div>
	
	
	<input type="submit" value = "Connexion" >
		
	</form>	
</body>
</html>