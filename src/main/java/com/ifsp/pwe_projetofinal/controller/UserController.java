package com.ifsp.pwe_projetofinal.controller;

import com.ifsp.pwe_projetofinal.model.User;
import com.ifsp.pwe_projetofinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/pwe/getUser")
    public User getByEmail(@RequestBody User user){
        return userService.login(user.getEmail(),user.getPassword());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/pwe/postUser")
    public String post(@RequestBody User user){
        userService.post(user);
        return "usuario adicionado com sucesso!!!";
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/pwe/deleteUser")
    public String delete(@RequestBody User user){
        userService.delete(user.getId());
        return "usuario deletado com sucesso!!!";
    }
}
