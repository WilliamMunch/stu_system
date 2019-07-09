package com.school.stu_system.util;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class MyBasicErrorController implements ErrorController {

    private static final String ERROR_PATH ="/error";
    @RequestMapping(ERROR_PATH)
    public ResponseBean handleError(HttpServletRequest request){
        //获取statusCode 404等
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode==400)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.BAD_REQUEST);
        }
        else if(statusCode==401)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.UNAUTHORIZED);
        }
        else if(statusCode==402)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.PAYMENT_REQUIRED);
        }
        else if(statusCode==403)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.FORBIDDEN);
        }

        else if(statusCode==404)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.NOT_FOUND);
        }
        else if(statusCode==405)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.METHOD_NOT_ALLOWED);
        }
        else if(statusCode==406)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.NOT_ACCEPTABLE);
        }
        else if(statusCode==407)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.PROXY_AUTHENTICATION_REQUIRED);
        }
        else if(statusCode==408)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.REQUEST_TIMEOUT);
        }
        else if(statusCode==409)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.CONFLICT);
        }
        else if(statusCode==410)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.GONE);
        }
        else if(statusCode==411)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.LENGTH_REQUIRED);
        }
        else if(statusCode==412)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.PRECONDITION_FAILED);
        }
        else if(statusCode==413)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.REQUEST_ENTITY_TOO_LARGE);
        }
        else if(statusCode==414)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.REQUEST_URI_TOO_LONG);
        }
        else if(statusCode==415)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.UNSUPPORTED_MEDIA_TYPE);
        }
        else if(statusCode==416)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.REQUESTED_RANGE_NOT_SATISFIABLE);
        }
        else if(statusCode==417)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.EXPECTATION_FAILED);
        }
        else if(statusCode==500)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.INTERNAL_SERVER_ERROR);
        }
        else if(statusCode==501)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.NOT_IMPLEMENTED);
        }
        else if(statusCode==502)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.BAD_GATEWAY);
        }
        else if(statusCode==503)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.SERVICE_UNAVAILABLE);
        }

        else if(statusCode==504)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.GATEWAY_TIMEOUT);
        }
        else if(statusCode==505)
        {
            return new ResponseBean<>(false,null,UnicomResponseEnums.HTTP_VERSION_NOT_SUPPORTED);
        }

        return  new ResponseBean<>(false,UnicomResponseEnums.UNKNOWN_ERROR);
    }
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

}
