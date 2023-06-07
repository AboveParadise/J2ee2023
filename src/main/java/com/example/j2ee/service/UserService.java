package com.example.j2ee.service;


import cn.hutool.core.bean.BeanUtil;
import com.example.j2ee.dao.UserMapper;
import com.example.j2ee.entity.Book;
import com.example.j2ee.entity.User;
import com.example.j2ee.repos.UserRepository;
import com.example.j2ee.util.PageParam;
import com.example.j2ee.util.PageReturner;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    public User addUser(User user){
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

    public PageReturner getUserList(PageParam pageIn) {
        PageReturner pageReturner = new PageReturner();
        List<User> list = user_mapper.findUserByLike(pageIn.getKeyword());
        List<User> res = new ArrayList<>();
        int start = (pageIn.getCurrPage() - 1) * pageIn.getPageSize();
        int end = pageIn.getCurrPage() * pageIn.getPageSize();
        if(end > list.size()) {
            end = list.size();
        }
        res = list.subList(start, end);
        pageReturner.setList(res);
        pageReturner.setTotal(list.size());
        pageReturner.setCurrPage(pageIn.getCurrPage());
        pageReturner.setPageSize(pageIn.getPageSize());
        return pageReturner;
    }
    public void deleteUser(Integer id) {
        user_repository.deleteById(id);
    }
}
