package com.piko.Account_Service.Controller;

import com.piko.Account_Service.DTO.LoginRequest;
import com.piko.Account_Service.Model.User;
import com.piko.Account_Service.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    //    -----------------------to create new user----------------------
    @PostMapping("/create")
    public String createUser(@RequestBody User user) {

        return userService.createUser(user);
    }

    //   ------------------------- get user by username----------------------
    @GetMapping("getBy/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.findUserByUsername(username));
    }

    //    ------------------------- used to fetch the user by email and username-----------------
    @GetMapping("getBy/emailAndName/{email}/{username}")
    public ResponseEntity<User> getUserByEmailAndName(@PathVariable String email, @PathVariable String username) {
        return ResponseEntity.ok(userService.findUserByEmailAndName(email, username));
    }

    //------------------------------- *** login *** ---------------------
    @PostMapping("/login")
    public ResponseEntity<?> login(HttpSession session, @RequestBody LoginRequest request) {
        User user = userService.findUserByEmail(request.getEmail());

        if (user == null || !user.getPassword().equals(request.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }

        // Store user details in the session
        session.setAttribute("user", user);
        System.out.println("User stored in session: " + session.getAttribute("user"));
        System.out.println("Session ID on login: " + session.getId());
        return ResponseEntity.ok("Login successful");
    }
//-------------------------------- used for fetching user session--------------------
    @GetMapping("/user")
    public ResponseEntity<?> getUser(HttpSession session) {
        // Instead of returning the user stored in the session,
        // get the user ID from the session and re-fetch the user from the database.
        User sessionUser = (User) session.getAttribute("user");
        if (sessionUser == null) {
            System.out.println("User not found in session");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not logged in");
        }
        // Fetch updated user from the database
        User updatedUser = userService.findById(sessionUser.getId());
        return ResponseEntity.ok(updatedUser);
    }
//-----------------------------------for logout---------------------------------------
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logged out successfully");
    }

}
