package com.agri.agri.services;

import com.agri.agri.model.Loan;
import com.agri.agri.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan getLoanById(String id) {
        return loanRepository.findById(id).orElse(null);
    }

    public void deleteLoan(String id) {
        loanRepository.deleteById(id);
    }
}
