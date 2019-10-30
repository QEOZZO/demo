package com.example.demo.xml.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement(name = "order")
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
