package com.aginfotech.rural_finapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aginfotech.rural_finapp.model.LoanAccount;

@Repository
public interface LoanRepository extends CrudRepository<LoanAccount, Long> {

}
