package com.example.demo.common.util.xml;

import javax.xml.bind.annotation.XmlElement;

public class UserModel {

    private String id;
    private String password;
    private String name;
    private String age;

    @XmlElement(name = "id")
    public String getId() {
        return id;
    }

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

    @Override
    public int hashCode() {
        int result = id.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UserModel)) {
            return false;
        }
        UserModel userModel = (UserModel) obj;
        if (this == userModel) {
            return true;
        }
        if (userModel.id.equals(this.id)) {
            return true;
        } else {
            return false;
        }
    }

}
