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
				<form action='${pageContext.request.contextPath}/customer/search' method="POST" class="validated-form">

					<div class="form-group ">
						<div class="mt-5 mb-3 row">
							<label for="searchby" class="col-sm-2 col-form-label">Searchby:</label>

							<select class="col-sm-10" name="searchBy" id="searchBy">
								<option class="form-control" value="customerId">Customer
									Id</option>
								<option class="form-control" value="email">Email Id</option>
								<option class="form-control" value="mobNum">Mobile
									Number</option>
							</select>
						</div>

						<div class="mb-3 row">
							<label for="value" class="col-sm-2 col-form-label">Value</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="value" name="value"
									required>
							</div>
						</div>
						<div class="">

							<button type="submit" class="btn btn-outline-dark float-end">Search</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<%@ include file="../footer.html"%>
</body>
</html>