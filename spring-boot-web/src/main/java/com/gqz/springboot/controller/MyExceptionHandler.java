package com.gqz.springboot.controller;

import com.gqz.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MyExceptionHandler
 * @author: ganquanzhong
 * @date: 2019/9/18 14:45
 * 自己写一个异常处理器
 */

@ControllerAdvice
public class MyExceptionHandler  {

    //1.浏览器和客户端都是返回json数据
   /*
   @ResponseBody
   @ExceptionHandler(UserNotExistException.class)
    public Map<String ,Object> handlerException(Exception e){
        Map<String , Object> map = new HashMap<>();
        map.put("code","user.notExist");
        map.put("message",e.getMessage());
        return map;
    }
    */

   //2.使用forward
    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request){
        Map<String , Object> map = new HashMap<>();
//        Integer statusCode = (Integer) request
//         .getAttribute("javax.servlet.error.status_code");

        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.noExist");
        map.put("message",e.getMessage());
        request.setAttribute("ext",map);
        return "forward:/error";
    }

}
