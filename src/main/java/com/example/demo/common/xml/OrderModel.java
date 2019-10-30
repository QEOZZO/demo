package com.example.demo.common.xml;

import javax.xml.bind.annotation.XmlElement;

public class OrderModel {
    private String id;
    private String price;
    private String address;
    private String age;


    @Override
    public int hashCode() {
        int result = id.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof OrderModel)) {
            return false;
        }
        OrderModel orderModel = (OrderModel) obj;
        if (this == orderModel) {
            return true;
        }
        if (orderModel.id.equals(this.id)) {
            return true;
        } else {
            return false;
        }
    }

    @XmlElement(name = "id")
    public String getId() {
        this.hashCode();
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @XmlElement(name = "age")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
