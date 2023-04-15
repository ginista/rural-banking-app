<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width">
    <title>Customer Data</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
          integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
          crossorigin="anonymous">
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
            crossorigin="anonymous"></script>

    <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
            integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
            crossorigin="anonymous"></script>
</head>

<body class="d-flex flex-column min-vh-100">
<%@ include file="../header.html" %>
<div class="container overflow-hidden mt-3">
    <div class="row gy-3">
        <h3>Customer Details</h3>
        <div class="col-6">
            <div class="p-2 border bg-light">Customer Id: ${customer.id}</div>
        </div>
        <div class="col-6">
            <div class="p-2 border bg-light">Name: ${customer.name}</div>
        </div>
        <div class="col-6">
            <div class="p-2 border bg-light">Email: ${customer.email}</div>
        </div>
        <div class="col-6">
            <div class="p-2 border bg-light">Mobile Number:
                ${customer.mobileNumber}</div>
        </div>
        <div class="col-6">
            <div class="p-2 border bg-light">Address: ${customer.address}
            </div>
        </div>
        <div class="col-6">
            <form method="get" action="../customer/modify">
                <input type="hidden" name="customerId" value="${customer.id}"/>
                <button type="submit" class="btn btn-outline-dark float-end">Modify
                    Customer Details
                </button>
            </form>
        </div>

        <h3 class="mt-5">Loan Details</h3>

        <table class="table table-hover">
            <thead>
            <tr>
                <th>Loan Id</th>
                <th>Type</th>
                <th>Loan Amount</th>
                <th>Rate of Interest</th>
                <th>Tenure</th>
                <th>Opening date</th>
                <th>Amount Paid</th>
                <th>Status</th>
                <th>Last Paid Date</th>
                <th>Balance</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${customer.loanAccounts}" var="loanAccount">
                <tr>
                    <td><c:out value="${loanAccount.loanId}"/></td>
                    <td><c:out value="${loanAccount.type}"/></td>
                    <td><c:out value="${loanAccount.loanAmount}"/></td>
                    <td><c:out value="${loanAccount.interestRate}"/></td>
                    <td><c:out value="${loanAccount.tenure}"/></td>
                    <td><c:out value="${loanAccount.openDate}"/></td>
                    <td><c:out value="${loanAccount.paidAmount}"/></td>
                    <td><c:out value="${loanAccount.loanStatus}"/></td>
                    <td><c:out value="${loanAccount.lastPaidDate}"/></td>
                    <td><c:out value="${loanAccount.balance}"/></td>
                    <td>
                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-outline-dark"
                                data-bs-toggle="modal"
                                data-bs-target="#<c:out value="P${loanAccount.loanId}" />">
                            Pay
                        </button> <!-- Modal -->
                        <div class="modal fade"
                             id="<c:out value="P${loanAccount.loanId}" />" tabindex="-1"
                             role="dialog" aria-labelledby="exampleModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Pay Loan</h5>
                                        <button type="button" class="close" data-bs-dismiss="modal"
                                                aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <form id="PL${loanAccount.loanId}" method="POST"
                                              action="../customer/payLoan" class="validated-form">
                                            <div class="container ">
                                                <div class="row mb-2">
                                                    <div class="col-6 d-flex justify-content-start">
                                                        <label for="payLoanId" class="col-form-label">Loan
                                                            Id </label>
                                                    </div>
                                                    <div class="col-6">
                                                        <input type="number" id="payLoanId" name="payLoanId"
                                                               readonly
                                                               value="<c:out value="${loanAccount.loanId}"></c:out>">

                                                    </div>
                                                </div>

                                                <div class="row mb-2">
                                                    <div class="col-6 d-flex justify-content-start">
                                                        <label for="payLoanBalance" class="col-form-label">Balance
                                                            Amount</label>
                                                    </div>
                                                    <div class="col-6">
                                                        <input type="number" id="payLoanBalance"
                                                               name="payLoanBalance" class="form-control" readonly
                                                               required
                                                               value="<c:out value="${loanAccount.balance}"></c:out>">

                                                    </div>
                                                </div>
                                                <div class="row mb-2">
                                                    <div class="col-6 d-flex justify-content-start">
                                                        <label for="payLoanAmountToPay" class="col-form-label">Amount
                                                            to pay </label>
                                                    </div>
                                                    <div class="col-6">
                                                        <input type="number" id="payLoanAmountToPay"
                                                               name="payLoanAmountToPay" class="form-control"
                                                               aria-describedby="passwordHelpInline" min="0"
                                                               max="${loanAccount.balance}" required>

                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-outline-dark"
                                                data-bs-dismiss="modal">Close
                                        </button>
                                        <button type="submit" form="PL${loanAccount.loanId}"
                                                class="btn btn-primary">Pay
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <button class="btn btn-outline-dark navbar-toggle collapsed" type="button"
                                data-bs-toggle="collapse"
                                data-bs-target="#T${loanAccount.loanId}" aria-expanded="false"
                                aria-controls="T${loanAccount.loanId}">View Transactions
                        </button>
                    </td>
                </tr>
                <tr>
                    <td colspan="11">
                        <div class="collapse navbar-collapse" id="T${loanAccount.loanId}">
                            <div class="card card-body">
                                <table class="table table-hover">
                                    <tr>
                                        <td>Transaction Id</td>
                                        <td>Transaction Date</td>
                                        <td>Amount</td>
                                        <td>Type</td>
                                        <td>Balance</td>

                                    </tr>
                                    <c:forEach items="${loanAccount.transactions}"
                                               var="transaction">
                                        <tr>
                                            <td>${transaction.transactionId}</td>
                                            <td>${transaction.transactionDate}</td>
                                            <td>${transaction.transactionAmount}</td>
                                            <td>${transaction.transactionType}</td>
                                            <td>${transaction.balance}</td>
                                        </tr>
                                    </c:forEach>

                                </table>
                            </div>
                        </div>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>


        <!-- Button trigger modal -->
        <span class="text-center">
				<button type="button" class="btn btn-outline-dark"
                        data-bs-toggle="modal" data-bs-target="#exampleModal2">
					<i class="fa fa-plus-circle fa-2x center" aria-hidden="true"></i>
				</button> <span>
					<div class="text-center pt-3 fs-4">Add new Loan</div> <!-- Modal -->
					<div class="modal fade" id="exampleModal2" tabindex="-1"
                         role="dialog" aria-labelledby="exampleModalLabel2"
                         aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel2">New Loan</h5>
									<button type="button" class="close" data-bs-dismiss="modal"
                                            aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">

									<form id="addNewLoanForm" method="POST"
                                          action="../customer/loan" class="validated-form">
										<div class="container ">

											<div class="row mb-2">
												<div class="col-6 d-flex justify-content-start">
													<label for="newLoanCustId" class="col-form-label">Customer
														Id </label>
												</div>
												<div class="col-6">
													<input type="text" id="newLoanCustId" name="newLoanCustId"
                                                           readonly class="form-control-plaintext"
                                                           aria-describedby="passwordHelpInline"
                                                           value="${customer.id}">

												</div>
											</div>
											<div class="row mb-2">
												<div class="col-6 d-flex justify-content-start">
													<label for="newLoanType" class="col-form-label">Loan
														Type </label>
												</div>
												<div class="col-6">
													<select class="form-select" name="newLoanType"
                                                            aria-label="Default select example">
														<option selected value="Two Wheeler Loan">Two
															Wheeler Loan</option>
														<option value="Car Loan">Car Loan</option>
														<option value="Gold Loan">Gold Loan</option>
														<option value="Personal Loan">Personal Loan</option>
													</select>

												</div>
											</div>
											<div class="row mb-2">
												<div class="col-6 d-flex justify-content-start">
													<label for="newLoanTenure" class="col-form-label">
														Tenure (in Months) </label>
												</div>
												<div class="col-6">
													<select class="form-select" name="newLoanTenure"
                                                            aria-label="Default select example">
														<option selected value="12">12</option>
														<option value="24">24</option>
														<option value="36">36</option>
														<option value="48">48</option>
													</select>

												</div>
											</div>
											<div class="row mb-2">
												<div class="col-6 d-flex justify-content-start">
													<label for="newLoanAmount" class="col-form-label">Loan
														Amount </label>
												</div>
												<div class="col-6">
													<input type="number" id="newLoanAmount"
                                                           name="newLoanAmount" class="form-control"
                                                           aria-describedby="passwordHelpInline" min="0"
                                                           max="10000000" required>
												</div>
											</div>
										</div>
									</form>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-outline-dark"
                                            data-bs-dismiss="modal">Close</button>
									<button type="submit" form="addNewLoanForm"
                                            class="btn btn-primary">Save</button>
								</div>
							</div>
						</div>
					</div>
            <br> <br>
			</span>
        </span>
    </div>
</div>
<%@ include file="../footer.html" %>
</body>
</html>