package com.agri.agri.controller;

import com.agri.agri.model.Loan;
import com.agri.agri.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<Loan> createLoan(
            @RequestParam double loanAmount,
            @RequestParam String purposeOfLoan,
            @RequestParam("landOwnershipProof") MultipartFile landOwnershipProof,
            @RequestParam("incomeProof") MultipartFile incomeProof,
            @RequestParam double durationOfInternship) {

        // Here, you would typically handle file uploads, save them, and get their paths.
        String landOwnershipProofPath = saveFile(landOwnershipProof);
        String incomeProofPath = saveFile(incomeProof);

        Loan loan = new Loan();
        loan.setLoanAmount(loanAmount);
        loan.setPurposeOfLoan(purposeOfLoan);
        loan.setLandOwnershipProof(landOwnershipProofPath);
        loan.setIncomeProof(incomeProofPath);
        loan.setDurationOfInternship(durationOfInternship);

        Loan createdLoan = loanService.createLoan(loan);
        return ResponseEntity.ok(createdLoan);
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        List<Loan> loans = loanService.getAllLoans();
        return ResponseEntity.ok(loans);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable String id) {
        Loan loan = loanService.getLoanById(id);
        if (loan != null) {
            return ResponseEntity.ok(loan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable String id) {
        loanService.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }

    // Method to save the file
    private String saveFile(MultipartFile file) {
        // Logic to save the file to a directory and return the path
        // This is a placeholder; implement your file storage logic here
        return file.getOriginalFilename(); // Replace with actual file storage implementation
    }
}
