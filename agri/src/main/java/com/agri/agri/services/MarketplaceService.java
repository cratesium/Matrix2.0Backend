package com.agri.agri.services;

import com.agri.agri.model.Marketplace;
import com.agri.agri.repository.MarketplaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketplaceService {

    @Autowired
    private MarketplaceRepository marketplaceRepository;

    public Marketplace createEntry(Marketplace marketplace) {
        return marketplaceRepository.save(marketplace);
    }

    public List<Marketplace> getAllEntries() {
        return marketplaceRepository.findAll();
    }

    public Marketplace getEntryById(String id) {
        return marketplaceRepository.findById(id).orElse(null);
    }

    public void deleteEntry(String id) {
        marketplaceRepository.deleteById(id);
    }
}
