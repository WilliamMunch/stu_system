package com.school.stu_system.domain;

/**
 * @program: stu_system
 * @description: 友好提示枚举
 * @author: William Munch
 * @create: 2019-07-08 13:06
 **/
public enum MyResponseEnums {

    //Config Error 1xxx  基础配置异常
    CONNECTION_ERROR("1000", "网络连接请求失败"),
    DATABASE_ERROR("1001", "数据库异常"),
    SYSTEM_ERROR("1002", "系统错误"),
    //Success 2xxx  业务逻辑成功
    REGISTER_SUCCESS("2000", "注册成功"),
    LOGIN_SUCCESS("2001", "登陆成功"),
    LOGOUT_SUCCESS("2002", "已退出登录"),
    OPERATE_SUCCESS("2003", "操作成功"),
    SEND_EMAIL_SUCCESS("2004", "邮件已发送，请注意查收"),
    EDIT_PWD_SUCCESS("2005", "修改密码成功"),
    UPLOAD_FILE_SUCCESS("2006", "上传成功"),


    //Error 3xxx  业务逻辑失败
    REPEAT_REGISTER("3001", "重复注册"),
    NO_USER_EXIST("3002", "用户不存在"),
    INVALID_PASSWORD("3003", "密码错误"),
    NO_LOGIN("3004", "未登陆"),
    NO_FILE_SELECT("3005", "未选择文件"),
    ERROR_IDCODE("3006", "验证码不正确"),
    NO_RECORD("3007", "没有查到相关记录"),
    REPEAT_MOBILE("3008", "已存在此手机号"),
    REPEAT_EMAIL("3009", "已存在此邮箱地址"),
    INVALID_MOBILE("3010", "无效的手机号码"),
    INVALID_EMAIL("3011", "无效的邮箱"),
    INVALID_GENDER("3012", "无效的性别"),


    //Client Error 4xxx  客户端错误  仿照4xx的http错误
    BAD_REQUEST("4000", "错误的请求参数"),
    UNAUTHORIZED("4001", "未经授权"),
    PAYMENT_REQUIRED("4002", "付费请求"),
    FORBIDDEN("4003", "资源不可用"),
    NOT_FOUND("4004", "无效的访问路径"),
    METHOD_NOT_ALLOWED("4005", "不合法的请求方式"),
    NOT_ACCEPTABLE("4006", "不可接受"),
    PROXY_AUTHENTICATION_REQUIRED("4007", "需要代理身份验证"),
    REQUEST_TIMEOUT("4008", "请求超时"),
    CONFLICT("4009", "指令冲突"),
    GONE("4010", "文档永久地离开了指定的位置"),
    LENGTH_REQUIRED("4011", "需要CONTENT-LENGTH头请求"),
    PRECONDITION_FAILED("4012", "前提条件失败"),
    REQUEST_ENTITY_TOO_LARGE("4013", "请求实体太大"),
    REQUEST_URI_TOO_LONG("4014", "请求URI太长"),
    UNSUPPORTED_MEDIA_TYPE("4015", "不支持的媒体类型"),
    REQUESTED_RANGE_NOT_SATISFIABLE("4016", "请求的范围不可满足"),
    EXPECTATION_FAILED("4017", "期望失败"),


    //Server Error 5xxx  服务器错误  仿照5xx的http错误
    INTERNAL_SERVER_ERROR("5000", "内部服务器错误"),
    NOT_IMPLEMENTED("5001", "未实现"),
    BAD_GATEWAY("5002", "错误的网关"),
    SERVICE_UNAVAILABLE("5003", "服务不可用"),
    GATEWAY_TIMEOUT("5004", "网关超时"),
    HTTP_VERSION_NOT_SUPPORTED("5005", "HTTP版本不支持"),


    //终极赖皮手段
    UNKNOWN_ERROR("0000", "未知错误");

    private String code;
    private String msg;

    private MyResponseEnums(String code, String msg) {

        this.code = code;
        this.msg = msg;
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
