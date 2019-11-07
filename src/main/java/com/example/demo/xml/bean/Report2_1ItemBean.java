package com.example.demo.xml.bean;

import com.example.demo.common.annotation.TypeBean;
import com.example.demo.common.base.bean.BaseBean;
import javax.xml.bind.annotation.XmlElement;

public class Report2_1ItemBean extends BaseBean {

    @TypeBean(type = {TypeBean.FieldType.USER})
    private String report2_1_id;
    @TypeBean(type = {TypeBean.FieldType.USER})
    private String report2_1_name_cn;
    @TypeBean(type = {TypeBean.FieldType.USER})
    private String report2_1_name_en;
    @TypeBean(type = {TypeBean.FieldType.USER})
    private Report2_1_1Bean report2_1_1Bean;

    @XmlElement(name = "report2_1_id")
    public String getReport2_1_id() {
        return report2_1_id;
    }

    public void setReport2_1_id(String report2_1_id) {
        this.report2_1_id = report2_1_id;
    }

    @XmlElement(name = "report2_1_name_cn")
    public String getReport2_1_name_cn() {
        return report2_1_name_cn;
    }

    public void setReport2_1_name_cn(String report2_1_name_cn) {
        this.report2_1_name_cn = report2_1_name_cn;
    }

    @XmlElement(name = "report2_1_name_en")
    public String getReport2_1_name_en() {
        return report2_1_name_en;
    }

    public void setReport2_1_name_en(String report2_1_name_en) {
        this.report2_1_name_en = report2_1_name_en;
    }

    @XmlElement(name = "report2_1_1")
    public Report2_1_1Bean getReport2_1_1Bean() {
        return report2_1_1Bean;
    }

    public void setReport2_1_1Bean(Report2_1_1Bean report2_1_1Bean) {
        this.report2_1_1Bean = report2_1_1Bean;
    }

    @Override
    public int hashCode() {
        int result = report2_1_id.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Report2_1ItemBean)) {
            return false;
        }
        Report2_1ItemBean userBean = (Report2_1ItemBean) obj;
        if (this == userBean) {
            return true;
        }
        if (userBean.report2_1_id.equals(this.report2_1_id)) {
            return true;
        } else {
            return false;
        }
    }

}
