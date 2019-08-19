package com.school.stu_system.util;

import com.school.stu_system.domain.MyResponse;
import com.school.stu_system.domain.MyResponseEnums;
import com.school.stu_system.domain.MyRuntimeException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.net.ConnectException;
import java.sql.SQLException;


/**
 * @program: stu_system
 * @description: 全局的异常处理类
 * @author: William Munch
 * @create: 2019-07-07 20:51
 **/
@RestControllerAdvice(annotations = {RestController.class, Controller.class})
public class ExceptionHandleUtil {


    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandleUtil.class);


    /*
     *
     * 总是返回 200，是否成功在 body 里面用一个字段来指示
     * 全200还有若干实际细节的好处，打比方阿里云看到你500 404什么的就会直接砍掉你的body，
     * 你的client到server之间有太多东西会经手你的http请求，大量使用200之外的状态码各种稀奇古怪的问题
     *
     *业务逻辑的异常都做处理，友好返回，status返回200
     *所有的异常也做友好返回，但是status显示404等真实状态码
     * */


    /**
     * 数据库操作出现异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {SQLException.class, DataAccessException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public MyResponse<String> systemError(Exception e) {
        logger.error("occurs error when execute method ,message {}", e.getMessage());
        return new MyResponse<>(false, MyResponseEnums.DATABASE_ERROR);
    }

    /**
     * 远程连接失败
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {ConnectException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public MyResponse<String> connect(Exception e) {
        logger.error("occurs error when execute method ,message {}", e.getMessage());
        return new MyResponse<>(false, MyResponseEnums.CONNECTION_ERROR);
    }


    /**
     * 自定义异常
     * 自定义抛出异常。统一的在这里捕获返回JSON格式的友好提示。
     *
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(value = {MyRuntimeException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public <T> MyResponse<T> sendError(MyRuntimeException exception, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        logger.error("occurs error when execute url ={} ,message {}", requestURI, exception.getMsg());
        return new MyResponse<>(false, exception.getCode(), exception.getMsg());
    }

}
