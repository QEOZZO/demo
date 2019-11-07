package com.example.demo.xml.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "data")
public class ReportMainBean {

    private Report2_1Bean report2_1Bean;

    @XmlElement(name = "report2_1")
    public Report2_1Bean getReport2_1Bean() {
        return report2_1Bean;
    }

    public void setReport2_1Bean(Report2_1Bean report2_1Bean) {
        this.report2_1Bean = report2_1Bean;
    }
}
