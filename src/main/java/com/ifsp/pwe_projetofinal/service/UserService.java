package com.ifsp.pwe_projetofinal.service;

import com.ifsp.pwe_projetofinal.DAO.UserRepository;
import com.ifsp.pwe_projetofinal.model.User;
import com.ifsp.pwe_projetofinal.model.UserLogin;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User register(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(user.getPassword());
        user.setPassword(password);
        return userRepository.save(user);
    }

    public Optional<UserLogin> login(Optional<UserLogin> userLogin) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Optional<User> user = userRepository.findByUsername(userLogin.get().getUsername());

        if (user.isPresent()) {

            if (encoder.matches(userLogin.get().getPassword(), user.get().getPassword())) {

                String auth = userLogin.get().getUsername() + ":" + userLogin.get().getPassword();

                byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));

                String authHeader = "Basic " + new String(encodeAuth);

                userLogin.get().setToken(authHeader);

                return userLogin;
            }
        }
        return null;


    }


    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }
}