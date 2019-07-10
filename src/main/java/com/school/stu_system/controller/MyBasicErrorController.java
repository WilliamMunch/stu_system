package com.school.stu_system.controller;


import com.school.stu_system.domain.MyResponse;
import com.school.stu_system.domain.MyResponseEnums;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: stu_system
 * @description: 统一处理一些映射到/error的错误
 * 这些错误出现时，spring-boot默认会由DefaultHandlerExceptionResolver做处理，然后将请求映射到 /error 路径中去，如果没有相应的路径请求处理器，那么就会返回默认的Whitelabel 错误页面
 * 在这里我将统一处理这些映射到/error的错误，予以友好返回Json
 * @author: William Munch
 * @create: 2019-07-08 22:00
 **/

@RestController
@ApiIgnore
public class MyBasicErrorController implements ErrorController {

    private static final String ERROR_PATH ="/error";
    @RequestMapping(ERROR_PATH)
    public MyResponse handleError(HttpServletRequest request){
        //获取statusCode 404等
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode==400)
        {
            return new MyResponse<>(false,null, MyResponseEnums.BAD_REQUEST);
        }
        else if(statusCode==401)
        {
            return new MyResponse<>(false,null, MyResponseEnums.UNAUTHORIZED);
        }
        else if(statusCode==402)
        {
            return new MyResponse<>(false,null, MyResponseEnums.PAYMENT_REQUIRED);
        }
        else if(statusCode==403)
        {
            return new MyResponse<>(false,null, MyResponseEnums.FORBIDDEN);
        }

        else if(statusCode==404)
        {
            return new MyResponse<>(false,null, MyResponseEnums.NOT_FOUND);
        }
        else if(statusCode==405)
        {
            return new MyResponse<>(false,null, MyResponseEnums.METHOD_NOT_ALLOWED);
        }
        else if(statusCode==406)
        {
            return new MyResponse<>(false,null, MyResponseEnums.NOT_ACCEPTABLE);
        }
        else if(statusCode==407)
        {
            return new MyResponse<>(false,null, MyResponseEnums.PROXY_AUTHENTICATION_REQUIRED);
        }
        else if(statusCode==408)
        {
            return new MyResponse<>(false,null, MyResponseEnums.REQUEST_TIMEOUT);
        }
        else if(statusCode==409)
        {
            return new MyResponse<>(false,null, MyResponseEnums.CONFLICT);
        }
        else if(statusCode==410)
        {
            return new MyResponse<>(false,null, MyResponseEnums.GONE);
        }
        else if(statusCode==411)
        {
            return new MyResponse<>(false,null, MyResponseEnums.LENGTH_REQUIRED);
        }
        else if(statusCode==412)
        {
            return new MyResponse<>(false,null, MyResponseEnums.PRECONDITION_FAILED);
        }
        else if(statusCode==413)
        {
            return new MyResponse<>(false,null, MyResponseEnums.REQUEST_ENTITY_TOO_LARGE);
        }
        else if(statusCode==414)
        {
            return new MyResponse<>(false,null, MyResponseEnums.REQUEST_URI_TOO_LONG);
        }
        else if(statusCode==415)
        {
            return new MyResponse<>(false,null, MyResponseEnums.UNSUPPORTED_MEDIA_TYPE);
        }
        else if(statusCode==416)
        {
            return new MyResponse<>(false,null, MyResponseEnums.REQUESTED_RANGE_NOT_SATISFIABLE);
        }
        else if(statusCode==417)
        {
            return new MyResponse<>(false,null, MyResponseEnums.EXPECTATION_FAILED);
        }
        else if(statusCode==500)
        {
            return new MyResponse<>(false,null, MyResponseEnums.INTERNAL_SERVER_ERROR);
        }
        else if(statusCode==501)
        {
            return new MyResponse<>(false,null, MyResponseEnums.NOT_IMPLEMENTED);
        }
        else if(statusCode==502)
        {
            return new MyResponse<>(false,null, MyResponseEnums.BAD_GATEWAY);
        }
        else if(statusCode==503)
        {
            return new MyResponse<>(false,null, MyResponseEnums.SERVICE_UNAVAILABLE);
        }

        else if(statusCode==504)
        {
            return new MyResponse<>(false,null, MyResponseEnums.GATEWAY_TIMEOUT);
        }
        else if(statusCode==505)
        {
            return new MyResponse<>(false,null, MyResponseEnums.HTTP_VERSION_NOT_SUPPORTED);
        }

        return  new MyResponse<>(false, MyResponseEnums.UNKNOWN_ERROR);
    }
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

}
