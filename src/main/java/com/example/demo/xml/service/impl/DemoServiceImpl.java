package com.example.demo.xml.service.impl;

import com.example.demo.common.annotation.TypeBean;
import com.example.demo.common.base.service.impl.BaseServiceImpl;
import com.example.demo.common.entity.MsgModel;
import com.example.demo.common.util.ResponseStatusUtil;
import com.example.demo.xml.bean.*;
import com.example.demo.xml.entity.Report2_1Entity;
import com.example.demo.xml.entity.Report2_1_1Entity;
import com.example.demo.xml.service.DemoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service(value = "demoService")
public class DemoServiceImpl extends BaseServiceImpl implements DemoService {
    @Override
    public MsgModel testSave(ReportMainBean reportMainBean) {

        MsgModel msgModel = new MsgModel();
        boolean isError = false;
        String errorMsg = "";

        Report2_1Bean report2_1Bean = reportMainBean.getReport2_1Bean();
        if(report2_1Bean!=null &&report2_1Bean.getReport2_1ItemBeans()!=null){
            for (Report2_1ItemBean report2_1ItemBean : report2_1Bean.getReport2_1ItemBeans()) {
                try {
                    Report2_1Entity report2_1Entity = new Report2_1Entity();
                    BeanUtils.copyProperties(report2_1ItemBean, report2_1Entity, getIgnoreProperties(report2_1ItemBean, TypeBean.FieldType.USER));
                    //todo 保存report2_1Entity

                    Report2_1_1Bean report2_1_1Bean= report2_1ItemBean.getReport2_1_1Bean();
                    if(report2_1_1Bean!=null&&report2_1_1Bean.getReport2_1_1ItemBeans()!=null){
                        for (Report2_1_1ItemBean report2_1_1ItemBean : report2_1_1Bean.getReport2_1_1ItemBeans()) {
                            try {
                                Report2_1_1Entity report2_1_1Entity = new Report2_1_1Entity();
                                BeanUtils.copyProperties(report2_1_1ItemBean, report2_1_1Entity, getIgnoreProperties(report2_1_1ItemBean, TypeBean.FieldType.USER));
                                //todo 保存report2_1_1Entity
                            } catch (Exception e) {
                                isError = true;
                                errorMsg += e.getMessage() + "<br>";
                                e.printStackTrace();
                                continue;
                            }
                        }
                    }
                    System.out.println("执行完毕！");
                } catch (Exception e) {
                    isError = true;
                    errorMsg += e.getMessage() + "<br>";
                    e.printStackTrace();
                    continue;
                }
            }
        }
        if (isError) {
            msgModel.setStatus(ResponseStatusUtil.s500);
            msgModel.setMsg(errorMsg);
        } else {
            msgModel.setStatus(ResponseStatusUtil.s200);
        }
        return msgModel;
    }

}
