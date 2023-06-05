package com.example.j2ee.service;


import cn.hutool.core.bean.BeanUtil;
import com.example.j2ee.dao.UserMapper;
import com.example.j2ee.entity.User;
import com.example.j2ee.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        System.out.println(username);
        String role = String.valueOf(user.getIs_admin());
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_" + role));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                password_encoder.encode(user.getPwd()), authorityList);
    }
    public User findByUsername(String username) {
        return user_repository.findByUsername(username);
    }
    public User findUserById(Integer id) {
        Optional<User> optional = user_repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUser(User user) {
        return user_mapper.updateUser(BeanUtil.beanToMap(user))>0;
    }

}
