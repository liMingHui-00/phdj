package com.lmh.ph.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class CrossFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse resp, FilterChain
            chain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) resp;
        //Access-Control-Allow-Origin:可以跨域请求的资源地址
        response.setHeader("Access-Control-Allow-Origin", "*");
		//Access-Control-Allow-Methods:可以跨域请求的方式
        response.setHeader("Access-Control-Allow-Methods", "*");
		//Access-Control-Allow-Headers响应头包含的内容
        response.setHeader("Access-Control-Allow-Headers", "*");
		//Access-Control-Max-Age:配置跨域请求时预判请求的间隔请求时间
		//0表示不间隔，3600表示每个小时预判一次
        response.setHeader("Access-Control-Max-Age", "3600");
		//Access-Control-Allow-Credentials凭证
        response.setHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(request, response);
    }
}
