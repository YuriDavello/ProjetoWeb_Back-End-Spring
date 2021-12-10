package com.ifsp.pwe_projetofinal.controller;

import com.ifsp.pwe_projetofinal.model.User;
import com.ifsp.pwe_projetofinal.model.UserLogin;
import com.ifsp.pwe_projetofinal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/findById/{id}")
    public ResponseEntity<Optional<User>>getById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(userService.getById(id));
    }

    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.register(user));
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody UserLogin userLogin){
        return new ResponseEntity<>(userService.login(userLogin), HttpStatus.OK);
    }
}
