package com.example.demo.common.filter;

import com.example.demo.common.utils.NetworkUtil;
import com.example.demo.controller.BaseController;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author jiwei.chen
 * @create 2018-11-06
 * @detail 请求地址拦截
 */
public class IPFilter extends BaseController implements Filter {

    List<String> blackIps = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        blackIps = Arrays.asList("127.0.0.2");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("过滤请求IP地址");
        //获取请求地址
        String address = NetworkUtil.getIpAddress((HttpServletRequest) servletRequest);
        System.out.println(address);
        if (blackIps.contains(address)){
            System.out.println("被过滤的请求IP地址："+address);
            return;
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
