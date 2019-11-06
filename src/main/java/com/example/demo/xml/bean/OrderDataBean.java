package com.example.demo.xml.bean;

import javax.xml.bind.annotation.XmlElement;
import java.util.Set;

public class OrderDataBean {
    private Set<OrderBean> orderBeans;

    @XmlElement(name = "item")
    public Set<OrderBean> getOrderBeans() {
        return orderBeans;
    }

    public void setOrderBeans(Set<OrderBean> orderBeans) {
        this.orderBeans = orderBeans;
    }
}
