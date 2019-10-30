package com.example.demo.xml.service.impl;

import com.example.demo.common.annotation.TypeBean;
import com.example.demo.common.base.service.impl.BaseServiceImpl;
import com.example.demo.common.entity.MsgModel;
import com.example.demo.common.util.ResponseStatusUtil;
import com.example.demo.xml.bean.MainDataBean;
import com.example.demo.xml.bean.UserBean;
import com.example.demo.xml.bean.UserDataBean;
import com.example.demo.xml.entity.UserEntity;
import com.example.demo.xml.service.DemoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service(value = "demoService")
public class DemoServiceImpl extends BaseServiceImpl implements DemoService {
    @Override
    public MsgModel testSave(MainDataBean mainDataBean) {
        MsgModel msgModel = new MsgModel();
        UserDataBean userDataBean = mainDataBean.getUserDataBean();
        boolean isError = false;
        String errorMsg = "";
        for (UserBean userBean : userDataBean.getUserBeans()) {
            try {
                UserEntity userEntity = new UserEntity();
                BeanUtils.copyProperties(userBean, userEntity, getIgnoreProperties(userBean, TypeBean.FieldType.USER));
                System.out.println("111111");
            } catch (Exception e) {
                isError = true;
                errorMsg += e.getMessage() + "<br>";
                e.printStackTrace();
                continue;
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
