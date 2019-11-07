package com.example.demo.xml.bean;

import javax.xml.bind.annotation.XmlElement;
import java.util.Set;

public class Report2_1Bean {

    private Set<Report2_1ItemBean> report2_1ItemBeans;


    @XmlElement(name = "item")
    public Set<Report2_1ItemBean> getReport2_1ItemBeans() {
        return report2_1ItemBeans;
    }

    public void setReport2_1ItemBeans(Set<Report2_1ItemBean> report2_1ItemBeans) {
        this.report2_1ItemBeans = report2_1ItemBeans;
    }


}
