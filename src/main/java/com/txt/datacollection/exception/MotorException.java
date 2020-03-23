package com.txt.datacollection.exception;

public enum MotorException {
    CANTFIND(1, "系统错误"),;


    private Integer code;
    private String msg;

    MotorException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
