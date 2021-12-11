package com.ifsp.pwe_projetofinal.security;

import com.ifsp.pwe_projetofinal.DAO.UserRepository;
import com.ifsp.pwe_projetofinal.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceDetailsImp implements UserDetailsService {
    private final UserRepository userRepository;

    public UserServiceDetailsImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> user = this.userRepository.findByUsername(username);
        user
                .orElseThrow(
                        () -> new UsernameNotFoundException(username + "not found")
                );
        return user.map(UserDetailsImp::new).get();
    }
}
