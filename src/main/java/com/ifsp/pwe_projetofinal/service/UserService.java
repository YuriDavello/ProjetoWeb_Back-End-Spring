package com.ifsp.pwe_projetofinal.service;

import com.ifsp.pwe_projetofinal.DAO.UserRepository;
import com.ifsp.pwe_projetofinal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getById(Long id){
        return userRepository.findById(id).get();
    }

    public User login(String email, String password){
        User user = userRepository.findByEmail(email);
        if(password.equals(user.getPassword())){
            return user;
        } else {
            return null;
        }
    }

    public void post(User user){
        userRepository.save(user);
    }

    public void update(Long id, User user){
        User aux = getById(id);
        aux.setEmail(user.getEmail());
        aux.setPassword(user.getPassword());
        aux.setUsersData(user.getUsersData());
        aux.setIsAdmin(user.getIsAdmin());
        userRepository.save(aux);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
