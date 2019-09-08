package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户信息controller
 * @Author: chaiqianlong
 * @Date: 2019-09-08 19:41
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getUser/{id}")
    public String GetUser(@PathVariable int id) {
        UserEntity userEntity = userService.getById(id);
        if (userEntity != null) {
            return userEntity.toString();
        }
        return "获取用户信息为空";
    }

}
