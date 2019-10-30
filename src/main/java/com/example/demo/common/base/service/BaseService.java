package com.example.demo.common.base.service;

import com.example.demo.common.annotation.TypeBean;
import com.example.demo.common.base.bean.BaseBean;

public interface BaseService {

    String[] getIgnoreProperties(BaseBean baseBean, TypeBean.FieldType fieldType);

}
