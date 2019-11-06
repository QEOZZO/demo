package com.example.demo.xml.bean;

import com.example.demo.common.annotation.TypeBean;
import com.example.demo.common.base.bean.BaseBean;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class UserBean extends BaseBean {

    @TypeBean(type = {TypeBean.FieldType.USER})
    private String user_id;
    @TypeBean(type = {TypeBean.FieldType.USER})
    private String password;
    @TypeBean(type = {TypeBean.FieldType.USER})
    private String name;
    @TypeBean(type = {TypeBean.FieldType.USER})
    private String age;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        int result = user_id.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UserBean)) {
            return false;
        }
        UserBean userBean = (UserBean) obj;
        if (this == userBean) {
            return true;
        }
        if (userBean.user_id.equals(this.user_id)) {
            return true;
        } else {
            return false;
        }
    }


}
