package com.agri.agri.controller;

import com.agri.agri.model.Marketplace;
import com.agri.agri.services.MarketplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marketplace")
public class MarketplaceController {

    @Autowired
    private MarketplaceService marketplaceService;

    @PostMapping
    public ResponseEntity<Marketplace> createEntry(@RequestBody Marketplace marketplace) {
        Marketplace createdEntry = marketplaceService.createEntry(marketplace);
        return ResponseEntity.ok(createdEntry);
    }

    @GetMapping("/get-All")
    public ResponseEntity<List<Marketplace>> getAllEntries() {
        List<Marketplace> entries = marketplaceService.getAllEntries();
        return ResponseEntity.ok(entries);
    }

    @GetMapping("get-By-Id/{id}")
    public ResponseEntity<Marketplace> getEntryById(@PathVariable String id) {
        Marketplace entry = marketplaceService.getEntryById(id);
        if (entry != null) {
            return ResponseEntity.ok(entry);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable String id) {
        marketplaceService.deleteEntry(id);
        return ResponseEntity.noContent().build();
    }
}
