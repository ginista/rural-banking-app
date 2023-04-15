<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Banking Website</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous"/>
</head>
<body class="d-flex flex-column min-vh-100">
<%@ include file="header.html" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <h5>&nbsp${message}</h5>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
</nav>
<div class="container">
    </br>
    <h5>&nbsp</h5>
    <div class="row justify-content-center ">
        <div class="col-md-6">
            <h2>Hey...!!&#x1F600;</h2>
            <p>You can perform the below operations in our application</p>
            <ul>
                <li>Register a new customer</li>
                <li>Customer Lookup</li>
                <li>Modify existing customer details</li>
                <li>Provision loans to an existing customer</li>
                <li>Pay loan installment</li>
                <li>View transaction history</li>
                <li>And much more planned!</li>
            </ul>
            <p>Please reach out to our support team in case of any queries.</p>
        </div>
        <div class="col-md-6">
            <img src="bank-img.jpg" class="img-fluid" alt="Banking Image">
        </div>
    </div>
</div>
<%@ include file="footer.html" %>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
