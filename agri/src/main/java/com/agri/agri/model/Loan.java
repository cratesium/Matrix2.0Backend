package com.agri.agri.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

@Document(collection = "loans")
public class Loan {

    @Id
    private String id; // MongoDB ObjectId
    private double loanAmount;
    private String purposeOfLoan;
    private String landOwnershipProof; // Storing the file path or name
    private String incomeProof; // Storing the file path or name
    private double durationOfInternship;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getPurposeOfLoan() {
        return purposeOfLoan;
    }

    public void setPurposeOfLoan(String purposeOfLoan) {
        this.purposeOfLoan = purposeOfLoan;
    }

    public String getLandOwnershipProof() {
        return landOwnershipProof;
    }

    public void setLandOwnershipProof(String landOwnershipProof) {
        this.landOwnershipProof = landOwnershipProof;
    }

    public String getIncomeProof() {
        return incomeProof;
    }

    public void setIncomeProof(String incomeProof) {
        this.incomeProof = incomeProof;
    }

    public double getDurationOfInternship() {
        return durationOfInternship;
    }

    public void setDurationOfInternship(double durationOfInternship) {
        this.durationOfInternship = durationOfInternship;
    }
}
