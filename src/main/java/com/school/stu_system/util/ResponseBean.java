package com.school.stu_system.util;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @program: stu_system
 * @description: 返回的JSON数据结构标准
 * @author: William Munch
 * @create: 2019-07-08 13:04
 **/
/*
当我们提供接口的时候，  Ajax  返回的时候，当对象在转换  JSON  （序列化）的时候，值为Null 或者为“” 的字段还是输出来了。看上去不优雅。

现在我叙述三种方式来控制这种情况。

注解的方式（ @JsonInclude(JsonInclude.Include.NON_EMPTY)）
通过@JsonInclude 注解来标记，但是值的可选项有四类。
Include.Include.ALWAYS （Default / 都参与序列化）
Include.NON_DEFAULT（当Value 为默认值的时候不参与，如Int a; 当 a=0 的时候不参与）
Include.NON_EMPTY（当Value 为“” 或者null 不输出）
Include.NON_NULL（当Value 为null 不输出）
 */
//如果是null 不返回
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseBean <T> implements Serializable {
    private static final long serialVersionUID = -131753924340496746L;
    
    private boolean success;//是否成功
    private T data;//数据
    private String code;//  成功/失败编码
    private String msg;// 对应编码的含义

    public ResponseBean(){}

    public ResponseBean(boolean success, T data) {
        super();
        this.success = success;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseBean{" +
                "success=" + success +
                ", data=" + data +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    public ResponseBean(boolean success, T data, String code, String msg) {
        super();
        this.success = success;
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public ResponseBean(boolean success, String code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }
    public ResponseBean(boolean success,UnicomResponseEnums enums){
        this.success=success;
        this.code=enums.getCode();
        this.msg=enums.getMsg();
    }
    public ResponseBean(boolean success,T data,UnicomResponseEnums enums){
        this.success=success;
        this.data=data;
        this.code=enums.getCode();
        this.msg=enums.getMsg();
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
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

