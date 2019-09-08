package com.example.demo.service;

import com.example.demo.entity.UserEntity;

/**
 * 用户信息接口
 * @Author: chaiqianlong
 * @Date: 2019-09-08 19:43
 */

public interface UserService {

    /**
     * 根据用户ID获取用户实体信息
     * @param id
     * @return com.example.demo.entity.UserEntity
     * @Author: chaiqianlong
     * @Date: 2019-09-08 19:45
     */
    public UserEntity getById(int id);

}
