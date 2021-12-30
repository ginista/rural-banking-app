<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<title>Search</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
</head>

<body class="d-flex flex-column min-vh-100">
	<%@ include file="../header.html"%>
	</br>
	<h5>&nbsp ${message}</h5>

	<div class="container">

		<div class="row justify-content-center ">
			<div class="col-md-7">
				<form:form action='${pageContext.request.contextPath}/customer/modify' method="POST"
					class="validated-form" modelAttribute="modifyCustomer">
					<h1 class="text-center my-4">Modify Customer Form</h1>
					<div class="form-group ">
						<div class="mb-3 row">
							<form:label path="id" class="col-sm-3 col-form-label">Customer ID</form:label>
							<div class="col-sm-9">
								<form:input path="id" class="form-control" readonly="true" />
							</div>
						</div>
					</div>
					<div class="form-group ">
						<div class="mb-3 row">
							<form:label path="name" class="col-sm-3 col-form-label">Customer Name</form:label>
							<div class="col-sm-9">
								<form:input path="name" class="form-control" readonly="true" />
							</div>
						</div>
					</div>
					<div class="mb-3 row">
						<form:label path="mobileNumber" class="col-sm-3 col-form-label">Mobile Number</form:label>
						<div class="col-sm-9">
							<form:input path="mobileNumber" type="tel"
								placeholder="Please enter 10 digit mobile number"
								pattern="[0-9]{10}" class="form-control" required="required" />
						</div>
					</div>
					<div class="mb-3 row">
						<form:label path="email" class="col-sm-3 col-form-label">Email</form:label>
						<div class="col-sm-9">
							<form:input type="email" path="email" class="form-control" />
						</div>
					</div>
					<div class="mb-3 row">
						<form:label path="address" class="col-sm-3 col-form-label">Address</form:label>
						<div class="col-sm-9">
							<form:textarea path="address" class="form-control"
								required="required" />
						</div>
					</div>
					<div class="">

						<button type="submit" class="btn btn-outline-dark float-end">Save</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>

	<%@ include file="../footer.html"%>
</body>
</html>