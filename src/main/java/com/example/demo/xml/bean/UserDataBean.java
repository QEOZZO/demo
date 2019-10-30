package com.example.demo.xml.bean;

import javax.xml.bind.annotation.XmlElement;
import java.util.Set;

public class UserDataBean {
    private Set<UserBean> userBeans;

    @XmlElement(name = "item")
    public Set<UserBean> getUserBeans() {
        return userBeans;
    }

    public void setUserBeans(Set<UserBean> userBeans) {
        this.userBeans = userBeans;
    }
}
