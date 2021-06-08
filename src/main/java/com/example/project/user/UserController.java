package com.example.project.user;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/check") 
    public String state() {
        return "working";
    }
    
    //adding a user
    @PostMapping("/signUp")
    public String signUp(@RequestBody User user) {
        boolean result = userService.add(user);
        if(result) return "success";
        else return "failed";
    }

    //checking a user
    @PostMapping("/logIn")
    public String logIn(@RequestBody User user) {
        boolean result = userService.contains(user);
        if(result) return "success";
        else return "failed";

    }

    //removing a user
    @PostMapping("/deleteAccount")
    public String deleteAccount(@RequestBody User user) {
        boolean result = userService.remove(user);
        if(result) return "success";
        else return "failed";
    }

    //changing a password
    @PostMapping("/updatePassword/{password}")
    public String updatePassword(@RequestBody User user, @PathVariable String password) {
        boolean result = userService.updatePassword(user,password);
        if(result) return "success";
        else return "failed";
    }

    @GetMapping("/showUsers") 
    public HashMap<String, User> show() {
        return userService.show();
    }
    
}
