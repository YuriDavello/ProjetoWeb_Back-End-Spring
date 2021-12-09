package com.ifsp.pwe_projetofinal.service;

import com.ifsp.pwe_projetofinal.DAO.UsersDataRepository;
import com.ifsp.pwe_projetofinal.DAO.UserRepository;
import com.ifsp.pwe_projetofinal.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service @RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UsersDataRepository userDataRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        if(user == null){
            throw new UsernameNotFoundException("login not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                new ArrayList<>());
    }

    public User getById(Long id){
        return userRepository.findById(id).get();
    }

    public User login(String login, String password){
        User user = userRepository.findByLogin(login);
        if(password.equals(user.getPassword())){
            return user;
        } else {
            return null;
        }
    }

    public String post(User user){
        userDataRepository.save(user.getUsersData());
        userRepository.save(user);
        return "usuario adicionado!";
    }

    public String update(Long id, User user){
        User aux = getById(id);
        aux.setLogin(user.getLogin());
        aux.setPassword(user.getPassword());
        aux.setUsersData(user.getUsersData());
        aux.setIsAdmin(user.getIsAdmin());
        userRepository.save(aux);
        return "usuario alterado!";
    }

    public String delete(Long id){
        long data = userRepository.findById(id).get().getUsersData().getId();
        userRepository.deleteById(id);
        userDataRepository.deleteById(data);
        return "usuario deletado!";
    }
}
