package com.example.demo.xml.bean;

import com.example.demo.common.base.bean.BaseBean;

import javax.xml.bind.annotation.XmlElement;

public class UserBean extends BaseBean {

    private String id;
    private String password;
    private String name;
    private String age;
    private String price;
    private String address;

    @Override
    @XmlElement(name = "id")
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "age")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @XmlElement(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @XmlElement(name = "address")
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
