package com.ifsp.pwe_projetofinal.service;

import com.ifsp.pwe_projetofinal.DAO.UsersDataRepository;
import com.ifsp.pwe_projetofinal.DAO.UserRepository;
import com.ifsp.pwe_projetofinal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UsersDataRepository userDataRepository;

    @Autowired
    public UserService(UserRepository userRepository, UsersDataRepository userDataRepository){
        this.userRepository = userRepository;
        this.userDataRepository = userDataRepository;
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
        userDataRepository.save(user.getUsersData());
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
        long data = userRepository.findById(id).get().getUsersData().getId();
        userRepository.deleteById(id);
        userDataRepository.deleteById(data);
    }
}
