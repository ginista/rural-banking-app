package com.aginfotech.rural_finapp.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aginfotech.rural_finapp.model.Customer;
import com.aginfotech.rural_finapp.model.LoanAccount;
import com.aginfotech.rural_finapp.model.Transaction;
import com.aginfotech.rural_finapp.services.CustomerService;
import com.aginfotech.rural_finapp.services.LoanService;

@Controller
@RequestMapping("customer")
public class LoanController {

	@Autowired
	CustomerService customerService;

	@Autowired
	LoanService loanService;

	// Add New Loan
	@PreAuthorize("hasRole('ROLE_group1')")
	@PostMapping("loan")
	public String addNewLoan(@RequestParam("newLoanCustId") Long customerId,
			@RequestParam("newLoanType") String loanType, @RequestParam("newLoanAmount") Double loanAmount,
			@RequestParam("newLoanTenure") Long newLoanTenure, RedirectAttributes rattrs, ModelMap model) {
		List<String> errorList = new ArrayList<>();
		Customer customer = customerService.getCustomerById(customerId);
		if (customer != null) {
			LoanAccount newLoanAccount = new LoanAccount();
			newLoanAccount.initiateNewLoanAccount(loanType, loanAmount, newLoanTenure);
			customer.getLoanAccounts().add(newLoanAccount);
			System.out.println(errorList + "Error SIze: " + errorList.size());
			System.out.println(customer);
			Customer result = customerService.updateCustomer(customer, errorList);
			System.out.println(errorList + "Error SIze: " + errorList.size());
			System.out.println(customer);
			System.out.println(result);
			if (result != null) {
				rattrs.addFlashAttribute("message",
						"Loan Account for the Customer ID: " + customerId + " Created Successfully!!");
			} else {

				rattrs.addFlashAttribute("message",
						"Add New Loan Account for the Customer ID: " + customerId + " Failed!!");

			}
		} else {
			rattrs.addFlashAttribute("message", "Invalid Customer ID!!");
		}
		return "redirect:/";
	}

	// Pay Loan
	@PreAuthorize("hasRole('ROLE_group1')")
	@PostMapping("payLoan")
	public String payLoan(@RequestParam("payLoanId") Long loanId, @RequestParam("payLoanAmountToPay") Double payAmount,
			RedirectAttributes rattrs, ModelMap model) {
		if (loanId != null && loanId > 0L) {
			LoanAccount loanAccount = loanService.getLoanAccountById(loanId);
			if (loanAccount != null) {
				if (loanAccount.getBalance() >= payAmount) {
					if (loanAccount.getBalance() == payAmount) {
						loanAccount.setLoanStatus('I');
					}
					Double balance = loanAccount.getBalance() - payAmount;
					Double amountRepaid = loanAccount.getPaidAmount() + payAmount;
					loanAccount.setBalance(balance);
					loanAccount.setLastPaidDate(LocalDate.now());
					loanAccount.setPaidAmount(amountRepaid);
					Transaction newTransaction = new Transaction();
					newTransaction.initiateNewTransaction(payAmount, "Credit", balance);
					loanAccount.getTransactions().add(newTransaction);
					LoanAccount result = loanService.saveLoanAccount(loanAccount);
					if (result != null) {
						rattrs.addFlashAttribute("message",
								"Payment of " + payAmount + " for the Loan Id: " + loanId + " is Successful!!");
					} else {

						rattrs.addFlashAttribute("message", "Payment" + " Failed!! Please Retry After Sometime!!");

					}
				} else {
					rattrs.addFlashAttribute("message",
							"Pay Amount should be less than or equal to the total balance!!");
				}
			} else {
				rattrs.addFlashAttribute("message", "Invalid Loan ID!!");
			}
		}
		return "redirect:/";
	}
	
}
