package com.example.demo.mapper;

import com.example.demo.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * 用户信息mapper
 * @Author: chaiqianlong
 * @Date: 2019-09-08 19:43
 */

@Repository
public interface UserMapper {
    /**
     * 根据用户ID获取用户实体信息
     * @param id 用户id
     * @return com.example.demo.entity.UserEntity
     * @Author: chaiqianlong
     * @Date: 2019-09-08 19:44
     */
    UserEntity getById(int id);
}
