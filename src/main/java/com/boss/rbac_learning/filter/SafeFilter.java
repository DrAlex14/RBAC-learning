package com.boss.rbac_learning.filter;

import lombok.extern.log4j.Log4j2;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Log4j2
@WebFilter(filterName = "SafeFilter",urlPatterns = "/*")
public class SafeFilter implements Filter {
    private static final String CSS = ".css";
    private static final String JS = ".js";
    private static final String GIT = ".gif";
    private static final String LOGIN = "login";
    private static final String USER_LOGIN = "userLogin";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        log.info("SafeFilter拦截");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String uri = req.getRequestURI();

        //对静态资源做放行处理
        if (uri.endsWith(JS) || uri.endsWith(CSS) || uri.endsWith(GIT)) {
            filterChain.doFilter(req, res);
        } else {
            //对用户登录资源做放行
            if (uri.contains(LOGIN) || uri.contains(USER_LOGIN)) {
                filterChain.doFilter(req, res);
            } else {
                HttpSession session = req.getSession();

                //session.setAttribute("permission",list);
                List<String> userPermissions = (List<String>) session.getAttribute("permission");
                //开关
                boolean flag = false;
                for (String permission : userPermissions) {
                    if (uri.contains(permission)) {
                        flag = true;
                        break;
                    }
                }
                //根据开关的值来进行跳转
                if (flag) {
                    log.info("拥有权限，可以访问");
                    filterChain.doFilter(req, res);
                } else {
                    log.info("权限不足");
                    res.sendRedirect("roleError");
                }
            }
        }
    }

            @Override
            public void destroy () {

            }
}