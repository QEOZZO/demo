package com.example.demo.xml.bean;

import com.example.demo.common.annotation.TypeBean;
import com.example.demo.common.base.bean.BaseBean;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class UserBean extends BaseBean {

    @TypeBean(type = {TypeBean.FieldType.USER})
    private String id;
    @TypeBean(type = {TypeBean.FieldType.USER})
    private String password;
    @TypeBean(type = {TypeBean.FieldType.USER})
    private String name;
    @TypeBean(type = {TypeBean.FieldType.USER})
    private String age;
    @TypeBean(type = {TypeBean.FieldType.ORDER})
    private String price;
    @TypeBean(type = {TypeBean.FieldType.ORDER})
    private String address;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
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
        if (userBean.id.equals(this.id)) {
            return true;
        } else {
            return false;
        }
    }

}
