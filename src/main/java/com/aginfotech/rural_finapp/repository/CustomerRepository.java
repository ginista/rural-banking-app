package com.aginfotech.rural_finapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aginfotech.rural_finapp.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	@Query("From Customer where mobileNumber=?1")
	Customer findByMobileNumber(String mobileNumber);

	@Query("From Customer where email=?1")
	Customer findByEmailContainingIgnoreCase(String email);

	@Query("From Customer where id=?1")
	Optional<Customer> findByCustomerId(Long customerId);
}
