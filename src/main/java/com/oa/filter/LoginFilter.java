package com.oa.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author wyy
 * @date 2018/3/12
 */
@WebFilter(filterName = "LoginFilter",urlPatterns = "/*",initParams = {@WebInitParam(name = "excludeUrlFromXml",value = "/jsp/login.jsp,/index.html,/user/login.action")})
public class LoginFilter implements Filter {

    /**
     不需要过滤的文件类型字符串。js匹配正则表达式test
     */
    String excludeUrl = ".*\\.css$,.*\\.js$,.*\\.png$,.*\\.jpg$,.*\\.gif$,.*\\.JPEG$,/pictureCheckCode";

    /**
     * 不需要过滤的路径
     */
    private static String allExcludeUrl;

    /**
     *
     不需要进行过滤的模式集合
     */
    List<Pattern> excludeList;
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {


        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;

        //字符集过滤
/*        String method = request.getMethod();
        if (method.equalsIgnoreCase("post")){
            request.setCharacterEncoding("UTF-8");
        }
        if (method.equalsIgnoreCase("get")){
//            String s = new String(s.getBytes().)
        }*/


        //一般用request.getServletContext().getContextPath();不用 request.getContextPath();servlet（项目多了不一样），
        String contextPath = request.getServletContext().getContextPath();
        String contextPath1 = request.getContextPath();

        String requestURI = request.getRequestURI();

        //首页不需要过滤
/*        if (requestURI.equals("/login.html")){
            chain.doFilter(req,resp);
            return;
        }*/

        //首先判断是否需要过滤
        if (isUrlExclude(requestURI)){
            chain.doFilter(req,resp);
        }else {
            Object user = request.getSession().getAttribute("user");
            if (user == null){
                response.sendRedirect(request.getServletContext().getContextPath()+"/jsp/login.jsp");
            }else {
                chain.doFilter(req, resp);
            }
        }

    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        //配置文件的参数获取
        String s = config.getInitParameter("excludeUrlFromXml");
        allExcludeUrl = excludeUrl;

        if (s != null && !s.equals("")){
            allExcludeUrl += ","+s;
        }

        excludeList = new ArrayList<>();
        String[] token = allExcludeUrl.split(",");
        for (String str:token) {
            excludeList.add(Pattern.compile(str));
        }
    }

    //判断请求是否需要过滤的方法，如果不需要返回true，需要返回false
    private boolean isUrlExclude(String url){
        boolean flag = false;

        for (Pattern pattern: excludeList) {
            flag = pattern.matcher(url).matches();
            //如果有一个满足就返回true
            if (flag){
                return flag;
            }
        }
        return flag;
    }
}
