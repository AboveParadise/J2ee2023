package com.example.j2ee.service;


import com.example.j2ee.dao.UserMapper;
import com.example.j2ee.entity.User;
import com.example.j2ee.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.*;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserService implements UserDetailsService{
    @Autowired
    private UserRepository user_repository;
    @Autowired
    private UserMapper user_mapper;
    @Autowired
    private PasswordEncoder password_encoder;

    public User add_user(User user){
        return user_repository.saveAndFlush(user);
    }
    @Override
    public UserDetails loadUserByUsername(String username){
        User user = user_repository.findByUsername(username);
        System.out.println("username");
        String role = String.valueOf(user.getIs_admin());
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_" + role));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                password_encoder.encode(user.getPwd()), authorityList);
    }
    public User findByUsername(String username) {
        return user_repository.findByUsername(username);
    }

}
