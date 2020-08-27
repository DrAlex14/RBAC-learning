package com.boss.rbac_learning.filter;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
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

        //解决跨域问题
        String originHeader = req.getHeader("Origin");
        res.setHeader("Access-Control-Allow-Origin", originHeader);
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setHeader("Access-Control-Allow-Methods", "*");
        res.setHeader("Access-Control-Max-Age", "86400");
        res.setHeader("Access-Control-Allow-Headers","Timestamp,Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token,Access-Control-Allow-Headers");


        //对静态资源做放行处理
        if (uri.endsWith(JS) || uri.endsWith(CSS) || uri.endsWith(GIT)) {
            filterChain.doFilter(req, res);
        } else {
            //对用户登录资源做放行
            if (uri.contains(LOGIN) || uri.contains(USER_LOGIN) || uri.contains("nopermission")){
                filterChain.doFilter(req, res);
            } else {

                HttpSession session = req.getSession();

                log.info(session.getAttribute("permission"));
                List<String> userPermissions = (List<String>) session.getAttribute("permission");
                //开关
                boolean flag = false;

                log.info(userPermissions);
                log.info(uri);
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
                    res.sendRedirect("/nopermission");
                }
                filterChain.doFilter(req, res);//测试
            }
        }
    }

            @Override
            public void destroy () {

            }
}