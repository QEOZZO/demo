package com.example.demo.common.util.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement(name = "secend")
public class Secend {
    private Set<OrderModel> orderModels;

    @XmlElement(name = "item")
    public Set<OrderModel> getOrderModels() {
        return orderModels;
    }

    public void setOrderModels(Set<OrderModel> orderModels) {
        this.orderModels = orderModels;
    }
}
