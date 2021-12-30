package com.aginfotech.rural_finapp.model;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CUSTOMER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(generator = "cust", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "cust", sequenceName = "CUST_SEQ", allocationSize = 1)
	@Column(name = "CUST_ID")
	private Long id;
	@Column(name = "CUST_NAME")
	private String name;
	private String email;
	@Column(name = "MOB_NO")
	private String mobileNumber;
	private String address;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<LoanAccount> loanAccounts;

}
