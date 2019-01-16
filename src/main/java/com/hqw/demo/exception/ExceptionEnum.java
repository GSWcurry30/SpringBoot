package com.hqw.demo.exception;

import org.omg.CORBA.INTERNAL;

public enum ExceptionEnum {
    SYSTEM_ERROR(-1,"系统错误"),
    PRIMARY_SCHOOL(100,"小学生"),
    MIDELE_SCHOOL(101,"初中生"),
    HIGH_SCHOOL(102,"大学生"),
    ;
    private Integer code;

    private String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
