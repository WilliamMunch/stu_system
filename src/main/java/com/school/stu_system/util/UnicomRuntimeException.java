package com.school.stu_system.util;

/**
 * @program: stu_system
 * @description: 自定义异常  比如普通用户的越权行为，管理员修改超级管理员的信息，查找不存在的人，等等，系统会报告异常并提示信息
 * @author: William Munch
 * @create: 2019-07-08 13:07
 **/
public class UnicomRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 6863853281199294164L;
    protected String code;

    protected String msg;



    public UnicomRuntimeException() {
        super();
    }

    public UnicomRuntimeException(UnicomResponseEnums enums) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
