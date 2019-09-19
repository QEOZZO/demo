package com.example.demo.user.service;

import com.example.demo.user.entity.UserEntity;

/**
 * 用户信息接口
 * @Author: cql
 * @Date: 2019-09-08 19:43
 */

public interface UserService {

    /**
     * 根据用户ID获取用户实体信息
     * @param id
     * @return com.example.demo.entity.UserEntity
     * @Author: cql
     * @Date: 2019-09-08 19:45
     */
    public UserEntity getUserById(int id);

    /**
     * 新增用户
     * @param userEntity
     * @return void
     * @Author: cql
     * @Date: 2019-09-09 21:11
     */
    void addUser(UserEntity userEntity);
}
