package com.gqz.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @ClassName: MyErrorAttributes
 * @author: ganquanzhong
 * @date: 2019/9/18 15:36
 */

@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    //返回值的map就是页面和json能获取的所有字段信息
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company","con.gqz.top");

        //异常处理器携带的数据
        Map<String , Object> ext =(Map<String , Object>)webRequest.getAttribute("ext", 0);
        map.put("ext",ext);
        return map;
    }
}
