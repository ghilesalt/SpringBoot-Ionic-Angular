package com.example.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){

        this.userService = userService;
    }
    
    @GetMapping()
    @CrossOrigin(origins = {"http://localhost:8200","http://localhost:8080"})
	public List<User> getUser(){

        return userService.getUser();
    }

    @PostMapping()
    public void ajouternvUser(@RequestBody User user){
        userService.ajouterUser(user);
    }

    @DeleteMapping("{userId}")
    public void suppUser(
            @PathVariable ("userId") Long userId){
        userService.suppUser(userId);
    }

    @PutMapping("{userId}")
    public void majUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String username){
        userService.majUser(userId, username);
    }

}
