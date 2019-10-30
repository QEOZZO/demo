package com.example.demo.common.validate.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * @Description: spring validated 错误处理
 **/
public class SpringValidatedUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringValidatedUtil.class);

    /**
     * @Description: 验证错误处理
     */
    public static void dealErrors(BindingResult bindingResult) {
        List<ObjectError> list = bindingResult.getAllErrors();
        for (ObjectError objectError : list){
            LOGGER.error(objectError.getDefaultMessage());
        }
    }

}
