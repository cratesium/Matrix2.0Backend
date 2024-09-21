package com.agri.agri.controller;

import com.agri.agri.model.FeedbackbyAdmin;
import com.agri.agri.services.FeedbackServicebyAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackControllerforadmin {

    @Autowired
    private FeedbackServicebyAdmin feedbackService;

    @PostMapping("/insert")
    public ResponseEntity<FeedbackbyAdmin> createFeedback(@RequestBody FeedbackbyAdmin feedback) {
        FeedbackbyAdmin createdFeedback = feedbackService.createFeedback(feedback);
        return ResponseEntity.ok(createdFeedback);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<FeedbackbyAdmin>> getAllFeedbacks() {
        List<FeedbackbyAdmin> feedbacks = feedbackService.getAllFeedbacks();
        return ResponseEntity.ok(feedbacks);
    }

    @GetMapping("getbyid/{id}")
    public ResponseEntity<FeedbackbyAdmin> getFeedbackById(@PathVariable String id) {
        FeedbackbyAdmin feedback = feedbackService.getFeedbackById(id);
        if (feedback != null) {
            return ResponseEntity.ok(feedback);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("deletebyid/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable String id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.noContent().build();
    }
}
