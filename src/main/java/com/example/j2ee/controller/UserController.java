package com.example.j2ee.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.example.j2ee.dao.UserMapper;
import com.example.j2ee.entity.User;
import com.example.j2ee.service.UserService;
import com.example.j2ee.util.Returner;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @ApiOperation("获取当前用户登录信息")
    @GetMapping("/currUser")
    public Returner getCurrUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal!=null) {
            Map<String,Object> map = BeanUtil.beanToMap(principal);
            String username = (String) map.get("username");
            if (StrUtil.isNotBlank(username)) {
                User user = userService.findByUsername(username);
                return new Returner(200, user);
            }
        }
        return new Returner(404, "该用户不存在");
    }
    @ApiOperation("用户详情")
    @GetMapping("/detail")
    public Returner userDetail(Integer id) {
        User user = userService.findUserById(id);
        if (user!=null) {
            return new Returner(200, user);
        }

        return new Returner(404);
    }
    @ApiOperation("编辑用户")
    @PostMapping("/update")
    public Returner modifyUsers(@RequestBody User user) {
        return new Returner(200, userService.updateUser(user));
    }

}
