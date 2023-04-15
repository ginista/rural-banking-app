<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Banking Website</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body class = "d-flex flex-column min-vh-100">
<%@ include file="header.html"%>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Banking Website</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

	</nav>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6">
				<h1>Welcome to Our Banking Website</h1>
				<p>Our banking website offers a wide range of services, including:</p>
				<ul>
				<li>View Transanction History</li>
					<li>Withdrawal money</li>

					<li>Bill payment</li>
					<li>Account management</li>
					<li>And much more!</li>
				</ul>
				<p>Please login or register to access your account and start managing your finances today.</p>
			</div>
			<div class="col-md-6">
				<img src="/images/bankimg.jpg" class="img-fluid" alt="Bankingg Image">
			</div>
		</div>
	</div>
	<%@ include file="footer.html"%>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
