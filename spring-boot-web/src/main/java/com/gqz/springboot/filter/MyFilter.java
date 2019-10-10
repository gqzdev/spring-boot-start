package com.gqz.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName: MyFilter
 * @author: ganquanzhong
 * @date: 2019/9/18 16:51
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(request.getContentType()+" Filter Execute.....");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
