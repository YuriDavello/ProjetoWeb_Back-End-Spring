package com.ifsp.pwe_projetofinal.controller;

import com.ifsp.pwe_projetofinal.model.UsersData;
import com.ifsp.pwe_projetofinal.service.UsersDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin @RequiredArgsConstructor @RequestMapping("/pwe")
public class UsersDataController {
    private final UsersDataService usersDataService;

    @GetMapping("/getUsersData/{id}")
    public ResponseEntity<UsersData>getById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(usersDataService.getById(id));
    }

    @PutMapping("/updateUsersData")
    public ResponseEntity<String>update(@RequestBody UsersData usersData){
        return ResponseEntity.ok().body(usersDataService.update(usersData.getId(), usersData));
    }
}
