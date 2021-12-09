package com.ifsp.pwe_projetofinal.controller;

import com.ifsp.pwe_projetofinal.model.User;
import com.ifsp.pwe_projetofinal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin @RequiredArgsConstructor @RequestMapping("/pwe")
public class UserController {
    private final UserService userService;

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User>getById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(userService.getById(id));
    }

    @PostMapping("/postUser")
    public ResponseEntity<String>post(@RequestBody User user){
        return ResponseEntity.ok().body(userService.post(user));
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
