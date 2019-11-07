package com.example.demo.xml.bean;

import javax.xml.bind.annotation.XmlElement;
import java.util.Set;

public class Report2_1_1Bean {
    private Set<Report2_1_1ItemBean> report2_1_1ItemBeans;

    @XmlElement(name = "item")
    public Set<Report2_1_1ItemBean> getReport2_1_1ItemBeans() {
        return report2_1_1ItemBeans;
    }

    public void setReport2_1_1ItemBeans(Set<Report2_1_1ItemBean> report2_1_1ItemBeans) {
        this.report2_1_1ItemBeans = report2_1_1ItemBeans;
    }
}
