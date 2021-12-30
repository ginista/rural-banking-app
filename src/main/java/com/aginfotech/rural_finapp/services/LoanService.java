package com.aginfotech.rural_finapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aginfotech.rural_finapp.model.LoanAccount;
import com.aginfotech.rural_finapp.repository.LoanRepository;

@Service
public class LoanService {

	@Autowired
	LoanRepository loanRepository;

	public LoanAccount getLoanAccountById(Long loanId) {
		return loanRepository.findById(loanId).orElse(null);
	}

	public LoanAccount saveLoanAccount(LoanAccount loanAccount) {
		return loanRepository.save(loanAccount);
	}

}
