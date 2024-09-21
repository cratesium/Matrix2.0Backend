package com.agri.agri.repository;

import com.agri.agri.model.FeedbackbyAdmin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepositorybyAdmin extends MongoRepository<FeedbackbyAdmin, String> {
    // Additional query methods can be defined here
}
