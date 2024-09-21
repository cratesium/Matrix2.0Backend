package com.agri.agri.services;

import com.agri.agri.model.FeedbackbyAdmin;
import com.agri.agri.repository.FeedbackRepositorybyAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServicebyAdmin {

    @Autowired
    private FeedbackRepositorybyAdmin feedbackRepository;

    public FeedbackbyAdmin createFeedback(FeedbackbyAdmin feedback) {
        return feedbackRepository.save(feedback);
    }

    public List<FeedbackbyAdmin> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public FeedbackbyAdmin getFeedbackById(String id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    public void deleteFeedback(String id) {
        feedbackRepository.deleteById(id);
    }
}
