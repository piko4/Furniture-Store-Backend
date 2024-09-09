package com.piko.Account_Service.Service;

import com.piko.Account_Service.Model.User;
import com.piko.Account_Service.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findUserByUsername(String username) {
        return userRepository.findByusername(username);
    }

    public String createUser(User user) {
         userRepository.save(user);
        return "created" ;
    }

    public User findUserByEmail(String email) {
     return userRepository.findByemail(email);
    }

    public User findUserByEmailAndName(String email, String username) {
        return userRepository.findByEmailAndUsername(email,username);
    }
}
