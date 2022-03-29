package com.zxj.blog.config;

import com.zxj.blog.entity.User;
import com.zxj.blog.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerUserDetails implements UserDetailsService {
    @Autowired
    private BlogUserService blogUserService;

    @Autowired
    private BlogPasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> systemUser = blogUserService.getSystemUser();
        Optional<User> userOptional = systemUser.stream().filter(item -> item.getUsername().equals(username)).findAny();
        User userInfo = new User();
        if (userOptional.isPresent()){
            userInfo = userOptional.get();
        }
        String role = "";
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        return new org.springframework.security.core.userdetails
                .User(userInfo.getUsername(),
                passwordEncoder.encode(userInfo.getPassword()),authorities);
    }
}

