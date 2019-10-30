package com.example.demo.common.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "data")
public class Data {

    private First first;

    private Secend secend;

    @XmlElement(name = "first")
    public First getFirst() {
        return first;
    }

    public void setFirst(First first) {
        this.first = first;
    }

    @XmlElement(name = "secend")
    public Secend getSecend() {
        return secend;
    }

    public void setSecend(Secend secend) {
        this.secend = secend;
    }

}
