package com.aginfotech.rural_finapp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.aginfotech.rural_finapp.utils.Constants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LOAN_ACCOUNT_DETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanAccount {
	@Id
	@GeneratedValue(generator = "loan", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "loan", sequenceName = "LOAN_SEQ", allocationSize = 1)
	@Column(name = "LOAN_ID")
	private Long loanId;
	@Column(name = "LOAN_TYPE")
	private String type;
	@Column(name = "OPEN_DT")
	private LocalDate openDate;
	@Column(name = "INTEREST_RATE")
	private Long interestRate;
	private Long tenure;
	@Column(name = "LOAN_AMT")
	private double loanAmount;
	@Column(name = "PAID_AMT")
	private double paidAmount;
	@Column(name = "LOAN_STATUS")
	private char loanStatus;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Transaction> transactions;
	@Column(name = "LAST_PAID_DT")
	private LocalDate lastPaidDate;
	private double balance;

	public void initiateNewLoanAccount(String loanType, double loanAmount, Long tenure) {
		this.type = loanType;
		this.openDate = LocalDate.now();
		Long interestRate = Constants.loanInterestMap.get(loanType);
		if (interestRate == null) {
			interestRate = Constants.loanInterestMap.get("Default");
		}
		this.interestRate = interestRate;
		this.loanAmount = loanAmount;
		this.tenure = tenure;
		this.loanStatus = 'A';
		System.out.println(loanAmount + " " + interestRate + " " + tenure);
		this.balance = Math.ceil(loanAmount * (1.0 + (interestRate * tenure / 1200.0)));
	}
}
