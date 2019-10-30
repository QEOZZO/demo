package com.example.demo.common.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface XmlBean {

    FieldType[] type() default {};

    enum FieldType {
        HEHUO("1"),HEZUO("2");

        private String type;

        FieldType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
