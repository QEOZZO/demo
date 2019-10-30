package com.example.demo.xml.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement(name = "user")
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
