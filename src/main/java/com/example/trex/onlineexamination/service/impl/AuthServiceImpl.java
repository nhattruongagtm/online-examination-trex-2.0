package com.example.trex.onlineexamination.service.impl;

import com.example.trex.onlineexamination.model.Role;
import com.example.trex.onlineexamination.model.User;
import com.example.trex.onlineexamination.repository.AuthRepo;
import com.example.trex.onlineexamination.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService, UserDetailsService {

    @Autowired
    private AuthRepo authRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public User signUp(User user) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        Optional<User> user = authRepo.findByUsername(username);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (user.isPresent()) {
            log.info("User found in the database");
            for (Role role : user.get().getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            }
        } else {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }
        return new org.springframework.security.core.userdetails.User(user.get().getEmail(), user.get().getPassword(), authorities);
    }
}
