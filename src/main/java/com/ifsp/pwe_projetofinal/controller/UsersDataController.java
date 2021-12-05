package com.ifsp.pwe_projetofinal.controller;

import com.ifsp.pwe_projetofinal.model.UsersData;
import com.ifsp.pwe_projetofinal.service.UsersDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UsersDataController {
    private final UsersDataService usersDataService;

    @Autowired
    public UsersDataController(UsersDataService usersDataService){
        this.usersDataService = usersDataService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/pwe/getUsersData/{id}")
    public UsersData getById(@PathVariable("id") Long id){
        return usersDataService.getById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "pwe/updateUsersData")
    public String update(@RequestBody UsersData usersData){
        usersDataService.update(usersData.getId(), usersData);
        return "dados atualizados com sucesso!!!";
    }
}
