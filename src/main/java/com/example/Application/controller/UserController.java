package com.example.Application.controller;

import com.example.Application.repository.UserRepository;
import com.example.Application.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/adminpage")
    public String getAll(Model model){
        model.addAttribute("users", userRepository.getAll());
        return "ListOfUsers";
    }

    @PostMapping("/registerUser")
    public ResponseEntity<String> registerUser(@RequestParam("firstName") String firstName,
                                               @RequestParam("lastName") String lastName,
                                               @RequestParam("password") String password,
                                               @RequestParam("phoneNumber") int phoneNumber,
                                               @RequestParam("email") String email){

        String hashedPassword = passwordEncoder.encode(password);

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(hashedPassword);
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);

        List<User> userList = new ArrayList<>();
        userList.add(user);

        return userRepository.insertUser(userList);
    }
}
