package com.example.demo.common.base.service.impl;

import com.example.demo.common.annotation.TypeBean;
import com.example.demo.common.base.bean.BaseBean;
import com.example.demo.common.base.service.BaseService;
import com.example.demo.common.util.StringUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BaseServiceImpl implements BaseService {
    @Override
    public String[] getIgnoreProperties(BaseBean baseBean, TypeBean.FieldType fieldType) {
        List<String> listIgnoreProperties = new ArrayList();
        Field[] field = baseBean.getClass().getDeclaredFields();
        if(field != null){
            for(Field fie : field){
                if(!fie.isAccessible()){
                    fie.setAccessible(true);
                }
                TypeBean ediBean = fie.getAnnotation(TypeBean.class);
                if(null == ediBean || !StringUtil.arrayToList(ediBean.type()).contains(fieldType)){
                    listIgnoreProperties.add(fie.getName());
                }
            }
        }
        return listIgnoreProperties.toArray(new String[listIgnoreProperties.size()]);
    }
}
