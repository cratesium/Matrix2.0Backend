
package com.agri.agri.controller;

import com.agri.agri.model.User;
import com.agri.agri.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user.getUsername(), user.getPassword(), user.getMobileNo());
            return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser); // Return 201 Created
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null); // Return 409 Conflict for existing username
        }
    }
    

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        try {
            userService.loginUser(user.getUsername(), user.getPassword());
            return ResponseEntity.ok("Login successful!"); // Return 200 OK
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials"); // Return 401 Unauthorized
        }
    }
    
    @DeleteMapping("/delete/{username}")
     public ResponseEntity<?> deleteUserByUsername(@PathVariable String username) {
    boolean deleted = userService.deleteUserByUsername(username);
    if (deleted) {
        return ResponseEntity.ok("User deleted successfully.");
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
    }
}


    // Additional endpoints for OTP handling can be added here
}

