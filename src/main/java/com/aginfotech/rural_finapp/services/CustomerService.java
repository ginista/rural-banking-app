package com.aginfotech.rural_finapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.aginfotech.rural_finapp.model.Customer;
import com.aginfotech.rural_finapp.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public Customer saveCustomer(Customer customer, List<String> errorList) {
		validateCustomer(customer, errorList);
		if (errorList.size() == 0) {
			return customerRepository.save(customer);
		} else {
			return null;
		}
	}

	private void validateCustomer(Customer customer, List<String> errorList) {
		if (customer == null || customer.getId() != null) {
			errorList.add("Invalid Customer Data!!");
		} else if (!StringUtils.hasLength(customer.getMobileNumber()) || customer.getMobileNumber().length() != 10) {
			errorList.add("Invalid Mobile Number!!");
		} else if (getCustomerByMobNum(customer.getMobileNumber()) != null) {
			errorList.add("Mobile Number already exists!!");
		} else if (StringUtils.hasLength(customer.getEmail()) && getCustomerByEmailId(customer.getEmail()) != null) {
			errorList.add("Email ID already exists!!");
		}
	}

	public Customer getCustomerByEmailId(String email) {
		return customerRepository.findByEmailContainingIgnoreCase(email);
	}

	public Customer getCustomerByMobNum(String mobileNumber) {
		return customerRepository.findByMobileNumber(mobileNumber);
	}

	public Customer getCustomerById(Long customerId) {
		return customerRepository.findByCustomerId(customerId).orElse(null);
	}

	public Customer updateCustomer(Customer customer, List<String> errorList) {
		validateUpdateCustomer(customer, errorList);
		if (errorList.size() == 0) {
			return customerRepository.save(customer);
		} else {
			return null;
		}
	}

	private void validateUpdateCustomer(Customer customer, List<String> errorList) {
		if (customer == null || customer.getId() == null) {
			errorList.add("Invalid Customer Data!!");
		} else if (!StringUtils.hasLength(customer.getMobileNumber()) || customer.getMobileNumber().length() != 10) {
			errorList.add("Invalid Mobile Number!!");
		} else {
			Customer mobNum = getCustomerByMobNum(customer.getMobileNumber());
			if (mobNum != null && mobNum.getId() != customer.getId()) {
				errorList.add("Mobile Number already exists!!");
			} else if (StringUtils.hasLength(customer.getEmail())) {
				Customer email = getCustomerByMobNum(customer.getMobileNumber());
				if (email != null && email.getId() != customer.getId()) {
					errorList.add("Email ID already exists!!");
				}
			}
		}
	}

}
