package com.example.demo.common.filter;

import com.example.demo.common.utils.UserUtil;
import com.example.demo.controller.BaseController;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author jiwei.chen
 * @create 2018-11-06
 * @detail 用户登录过滤器
 */
public class UserFilter extends BaseController implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化用户过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
/*        logger.info(LoggerConst.LOGGER_PRE + "过滤用户");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getUserInfo((HttpServletRequest) servletRequest);*/

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            UserUtil.clearUserInfo();
        }
    }

    void getUserInfo(HttpServletRequest request) {
        String user = request.getParameter("user");
        if (!StringUtils.isEmpty(user)) {
            UserUtil.setLocalUser(user);
        }
    }

    @Override
    public void destroy() {

    }
}
