package com.agri.agri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @GetMapping("/hi")
    public ResponseEntity<String> returnHealth() {
        return ResponseEntity.ok("Working fine"); // Return 200 OK with message
    }
}
