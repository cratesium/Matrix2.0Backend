package com.agri.agri.repository;

import com.agri.agri.model.Marketplace;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketplaceRepository extends MongoRepository<Marketplace, String> {
    // Additional query methods can be defined here if needed
}
