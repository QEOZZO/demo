package com.example.demo.xml.bean;

import com.example.demo.common.annotation.TypeBean;
import com.example.demo.common.base.bean.BaseBean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class OrderBean extends BaseBean {

    @TypeBean(type = {TypeBean.FieldType.USER})
    private String order_id;
    @TypeBean(type = {TypeBean.FieldType.USER})
    private String price;
    @TypeBean(type = {TypeBean.FieldType.USER})
    private String address;


    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
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
        int result = order_id.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof OrderBean)) {
            return false;
        }
        OrderBean userBean = (OrderBean) obj;
        if (this == userBean) {
            return true;
        }
        if (userBean.order_id.equals(this.order_id)) {
            return true;
        } else {
            return false;
        }
    }

}
