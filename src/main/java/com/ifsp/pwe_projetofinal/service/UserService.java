package com.ifsp.pwe_projetofinal.service;

import com.ifsp.pwe_projetofinal.DAO.UserRepository;
import com.ifsp.pwe_projetofinal.model.User;
import com.ifsp.pwe_projetofinal.model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public String login(UserLogin userLogin) {
        List<User> users = userRepository.findAll();

        for (User user: users) {
            if (userLogin.getUsername() == user.getUsername()) {
                return "Logged in";
            }
        }
        return "Failed to log in";
    }

    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }
}
