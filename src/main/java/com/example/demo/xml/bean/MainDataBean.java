package com.example.demo.xml.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "data")
public class MainDataBean {

    private UserDataBean userDataBean;

    private OrderDataBean orderDataBean;

    @XmlElement(name = "user")
    public UserDataBean getUserDataBean() {
        return userDataBean;
    }

    public void setUserDataBean(UserDataBean userDataBean) {
        this.userDataBean = userDataBean;
    }

    @XmlElement(name = "order")
    public OrderDataBean getOrderDataBean() {
        return orderDataBean;
    }

    public void setOrderDataBean(OrderDataBean orderDataBean) {
        this.orderDataBean = orderDataBean;
    }

}
