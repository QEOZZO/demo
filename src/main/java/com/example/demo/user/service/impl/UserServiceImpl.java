package com.example.demo.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.common.util.RedisUtil;
import com.example.demo.user.entity.UserEntity;
import com.example.demo.user.mapper.UserMapper;
import com.example.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息接口实现类
 * @Author: cql
 * @Date: 2019-09-08 19:43
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisUtil redisUtil;

    /**
     * 根据用户ID获取用户实体信息
     * @param id
     * @return com.example.demo.entity.UserEntity
     * @Author: cql
     * @Date: 2019-09-08 19:45
     */
    @Override
    public UserEntity getUserById(int id) {
        return userMapper.getUserById(id);
    }

    /**
     * 新增用户
     * @param userEntity
     * @return void
     * @Author: cql
     * @Date: 2019-09-09 21:11
     */
    @Override
    public void addUser(UserEntity userEntity){
        userMapper.addUser(userEntity);
        redisUtil.set("user:"+userEntity.getId(), JSON.toJSONString(userEntity));
    }

}
