package com.tekup.mp.web.security.services;


import com.tekup.mp.jpa.enums.RoleEnum;
import com.tekup.mp.dao.GLOBAL.AppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tekup.mp.dao.UserRepository;
import com.tekup.mp.jpa.entities.User;

import java.util.HashSet;
import java.util.Set;

@Service("userService")
public class UserServiceSecurity implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceSecurity(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user present with username : " + username);
        } else {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            AppRepo.setUserRole(user.getRoles().toArray()[0].toString());
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
        }
    }
}
