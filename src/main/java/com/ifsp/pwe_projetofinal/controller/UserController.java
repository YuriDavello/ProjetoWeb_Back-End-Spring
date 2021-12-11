package com.ifsp.pwe_projetofinal.controller;

import com.ifsp.pwe_projetofinal.model.User;
import com.ifsp.pwe_projetofinal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@CrossOrigin("*") @RequiredArgsConstructor @RequestMapping("/pwe")
public class UserController {
    private final UserService userService;

    @GetMapping("findById/{id}")
    public ResponseEntity<Optional<User>> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(userService.getById(id));
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.register(user));
    }

    @PostMapping("login")
    public ResponseEntity<User> login(@RequestBody Optional<User> userLogin){
        return userService.login(userLogin)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PutMapping( "/updateUser")
    public ResponseEntity<String>update(@RequestBody User user){
        return ResponseEntity.ok().body(userService.update(user.getId(), user));
    }

    @DeleteMapping( "/deleteUser")
    public ResponseEntity<String>delete(@RequestBody User user){
        return ResponseEntity.ok().body(userService.delete(user.getId()));
    }
}
