package com.example.demo.common.base.service;

import com.example.demo.common.annotation.CorpTypeBean;
import com.example.demo.common.base.bean.BaseBean;

public interface BaseService {

    String[] getIgnoreProperties(BaseBean baseBean, CorpTypeBean.FieldType fieldType);

}
