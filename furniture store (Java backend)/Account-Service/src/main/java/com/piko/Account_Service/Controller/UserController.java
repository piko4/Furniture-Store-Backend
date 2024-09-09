package com.piko.Account_Service.Controller;

import com.piko.Account_Service.Model.User;
import com.piko.Account_Service.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/create")
    public String  createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("getBy/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username){
        return ResponseEntity.ok(userService.findUserByUsername(username));
    }

    @GetMapping("getBy/emailAndName/{email}/{username}")
    public ResponseEntity<User> getUserByEmailAndName(@PathVariable String email,@PathVariable String username){
        return ResponseEntity.ok(userService.findUserByEmailAndName(email,username));
    }

}
