<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>blah blah blah</title>
<link type="text/css" href="css/bootstrap.min.css" rel="stylesheet" />
<link type="text/css" href="css/dreszcz.css" rel="stylesheet" />
</head>
<body>
	<div class="container wrapper">
		<div class="background">
			<header>
				<img class="img-responsive" src="img/header.png" alt="Dreszcz" />
			</header>

			<nav>
				<ul>
					<li class="center-block text-center"><a href="#">home</a></li>
					<li class="center-block text-center"><a href="#">home</a></li>
					<li class="center-block text-center"><a href="#">home</a></li>
					<li class="center-block text-center"><a href="#">home</a></li>
					<li class="log-nav"><a href="#">Zaloguj się</a></li>
				</ul>
			</nav>
			
			<jsp:include page='<%=request.getAttribute("subPage").toString()%>' />
			

			<footer>
				<p class="text-center">&copy Giant's Castle</p>
			</footer>

		</div>
	</div>
</body>
</html>