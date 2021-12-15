package com.ifsp.pwe_projetofinal.service;

import com.ifsp.pwe_projetofinal.DAO.UsersDataRepository;
import com.ifsp.pwe_projetofinal.DAO.UserRepository;
import com.ifsp.pwe_projetofinal.model.User;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UsersDataRepository userDataRepository;
    private final PasswordEncoder passwordEncoder;

    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    public User register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDataRepository.save(user.getUsersData());
        userRepository.save(user);
        return user;
    }

    public Optional<User> login(Optional<User> userLogin) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Optional<User> user = userRepository.findByUsername(userLogin.get().getUsername());
        if (user.isPresent()) {
            if (passwordEncoder.matches(userLogin.get().getPassword(), user.get().getPassword())) {
                String auth = userLogin.get().getUsername() + ":" + userLogin.get().getPassword();
                byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodeAuth);
                userLogin.get().setToken(authHeader);
                return userLogin;
            }
        }
        return null;
    }

    public String update(Long id, User user){
        Optional<User> aux = getById(id);
        aux.get().setUsername(user.getUsername());
        aux.get().setPassword(user.getPassword());
        aux.get().setUsersData(user.getUsersData());
        userRepository.save(aux.get());
        return "usuario alterado!";
    }

        public String delete(Long id){
        long data = userRepository.findById(id).get().getUsersData().getId();
        userRepository.deleteById(id);
        userDataRepository.deleteById(data);
        return "usuario deletado!";
    }
}
