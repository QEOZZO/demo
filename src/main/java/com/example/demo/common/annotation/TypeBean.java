package com.example.demo.common.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface TypeBean {

    FieldType[] type() default {};

    enum FieldType {
        USER("1"),ORDER("2");

        private String type;

        FieldType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
