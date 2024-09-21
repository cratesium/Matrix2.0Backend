package com.agri.agri.repository;

import com.agri.agri.model.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends MongoRepository<Loan, String> {
    // Additional query methods can be defined here if needed
}
