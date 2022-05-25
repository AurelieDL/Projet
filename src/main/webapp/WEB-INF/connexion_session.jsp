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
	<header class="header">
		<nav class="navbar">
			<div class="container">
				<a href="#" class="navbar-brand text-uppercase font-weight-bold">ENI-ENCHERES</a>
			</div>
		</nav>
	</header>
	<section class="vh-100">
		<div class="container-fluid">
			<div class="row">
				<div class="text-black d-flex justify-content-center text-center">

					<div
						class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">

						<form action="/LoginServlet" method=post style="width: 23rem;">

							<h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">S'identifier</h3>

							<div class="form-outline mb-4">
								<input type="text" id="form2Example18"
									class="form-control form-control-lg" /> <label
									class="form-label" for="form2Example18">Identifiant</label>
							</div>

							<div class="form-outline mb-4">
								<input type="password" id="form2Example28"
									class="form-control form-control-lg" /> <label
									class="form-label" for="form2Example28">Mot de passe</label>
							</div>

							<div class="pt-1 mb-4">
								<button class="btn btn-info btn-lg btn-block" type="submit">Se connecter</button>
							</div>

							<p class="small mb-5 pb-lg-2">
								<a class="text-muted" href="#!">Mot de passe oublié</a>
							</p>
							<p>
								Pas de compte? <a href="#!" class="link-info">En créer un ici!</a>
							</p>

						</form>

					</div>

				</div>

			</div>
		</div>
	</section>
</body>
</html>