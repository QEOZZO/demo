package com.example.demo.user.controller;

import com.example.demo.user.entity.UserEntity;
import com.example.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 用户信息controller
 * @Author: cql
 * @Date: 2019-09-08 19:41
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser/{id}")
    @ResponseBody
    public String getUser(@PathVariable int id) {
        UserEntity userEntity = userService.getUserById(id);
        if (userEntity != null) {
            return userEntity.toString();
        }
        return "获取用户信息为空";
    }

    @GetMapping("addUser")
    public void addUser() {
        UserEntity userEntity = new UserEntity("chaiqianlong","123456","柴乾隆");
        userService.addUser(userEntity);
    }

}
