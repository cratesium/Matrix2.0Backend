// package com.agri.agri.controller;

// import com.agri.agri.model.User;
// import com.agri.agri.services.UserService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/users")
// public class UserController {

//     @Autowired
//     private UserService userService;

//     @PostMapping("/register")
//     public User registerUser(@RequestBody String username,
//                              @RequestBody String password,
//                              @RequestBody String mobileNo) {
//         return userService.registerUser(username, password, mobileNo);
//     }

//     @PostMapping("/login")
//     public User loginUser(@RequestParam String username,
//                           @RequestParam String password) {
//         return userService.loginUser(username, password);
//     }

//     // Additional endpoints for OTP handling can be added here
// }
package com.agri.agri.controller;

import com.agri.agri.model.User;
import com.agri.agri.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user.getUsername(), user.getPassword(), user.getMobileNo());
    }

    @PostMapping("/login")
    public User loginUser(@RequestParam String username, @RequestParam String password) {
        return userService.loginUser(username, password);
    }

    // Additional endpoints for OTP handling can be added here
}

