<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Oubli mot de passe</title>
</head>
<body>
	<h1>Mot de passe oublié</h1>
	
		<h2> Renseignez votre adresse mail </h2>
		
		<form method="post" action="ForgotPassword"> 
	<div>
		<label>Email:</label>
		<input type="text" name= "mail">
		<input type="submit" value = "Obtenir" >
	</div>
	</form>	
</body>
</html>