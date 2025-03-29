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
     * 业务逻辑的异常都做处理，友好返回，status返回200（HttpStatus.OK）
     * 系统运行期间的异常（例如空指针异常）也做 "系统错误"的返回，状态码也是200
     * 系统运行期间的异常中，有些我们单独处理，如下文的数据库异常，（特定异常），其余的才会走上边那条路
     *
     *
     * MyBasicErrorController里把映射到/error的错误也做友好返回，但是status显示404，500等真实状态码（保持HttpStatus），
     * 这些如果body被阿里截取调也没关系
     *
     * 因为系统异常做了处理，本该会被最终映射到500的错误上，因为处理了，状态码改了200，再配上错误提示，直接返回了。
     * 要是不做系统异常处理，映射到500，再映射到/error错误，错误提示就不会显示"系统错误"了，而会显示"内部服务器错误"
     * 又因为MyBasicErrorController没改状态码，所以甚至可能会被截了错误提示，只剩下500状态码
     */


    /*
     * 系统出现异常（能捕获所有的）
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public MyResponse systemError(Exception e) {
        logger.error("occurs error when execute method ,message {}", e.getMessage());
        return new MyResponse<>(false,MyResponseEnums.SYSTEM_ERROR);
    }

    /**
     * 数据库操作出现异常（特定异常）
     */
    @ExceptionHandler(value = {SQLException.class, DataAccessException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public MyResponse databaseError(Exception e) {
        logger.error("occurs error when execute method ,message {}", e.getMessage());
        return new MyResponse<>(false, MyResponseEnums.DATABASE_ERROR);
    }
    /**
     * 远程连接失败（特定异常）
     */
    @ExceptionHandler(value = {ConnectException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public MyResponse connectError(Exception e) {
        logger.error("occurs error when execute method ,message {}", e.getMessage());
        return new MyResponse<>(false, MyResponseEnums.CONNECTION_ERROR);
    }

    /*
     * 自定义异常（用于捕获自己业务中抛出的）
     */
    @ExceptionHandler(value = {MyRuntimeException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public  MyResponse myError(MyRuntimeException exception, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        logger.error("occurs error when execute url ={} ,message {}", requestURI, exception.getMsg());
        return new MyResponse<>(false, exception.getCode(), exception.getMsg());
    }

}
