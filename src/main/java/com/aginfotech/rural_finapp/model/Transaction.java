package com.aginfotech.rural_finapp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TRANSACTION_DETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	@Id
	@GeneratedValue(generator = "trans", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "trans", sequenceName = "TRAN_SEQ", allocationSize = 1)
	@Column(name = "TRANS_ID")
	private Long transactionId;
	@Column(name = "TRANS_DT")
	private LocalDate transactionDate;
	@Column(name = "TRANS_AMT")
	private double transactionAmount;
	@Column(name = "TRANS_TYPE")
	private String transactionType;
	private Double balance;

	public void initiateNewTransaction(Double payAmount, String transactionType, Double balance) {
		this.transactionDate = LocalDate.now();
		this.transactionAmount = payAmount;
		this.transactionType = transactionType;
		this.balance = balance;
	}
}
