package com.example.demo.common.base.bean;

import com.example.demo.common.validate.DeletePostGroup;
import com.example.demo.common.validate.UpdatePostGroup;
import com.example.demo.common.validate.ViewGetGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * @Description: 基类bean
 */
public class BaseBean {
    @NotEmpty(groups = {ViewGetGroup.class, UpdatePostGroup.class, DeletePostGroup.class}, message = "id为空")
    @Length(min = 1, max = 32, groups = {ViewGetGroup.class, UpdatePostGroup.class, DeletePostGroup.class}, message = "id长度不符合要求")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
