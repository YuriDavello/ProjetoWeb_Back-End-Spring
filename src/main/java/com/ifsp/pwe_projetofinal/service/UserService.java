package com.ifsp.pwe_projetofinal.service;

import com.ifsp.pwe_projetofinal.DAO.UsersDataRepository;
import com.ifsp.pwe_projetofinal.DAO.UserRepository;
import com.ifsp.pwe_projetofinal.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service @RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UsersDataRepository userDataRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("login not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public User getById(Long id){
        return userRepository.findById(id).get();
    }

    public User login(String username, String password){
        User user = userRepository.findByUsername(username);
        if(password.equals(user.getPassword())){
            return user;
        } else {
            return null;
        }
    }

    public String post(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDataRepository.save(user.getUsersData());
        userRepository.save(user);
        return "usuario adicionado!";
    }

    public String update(Long id, User user){
        User aux = getById(id);
        aux.setUsername(user.getUsername());
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
