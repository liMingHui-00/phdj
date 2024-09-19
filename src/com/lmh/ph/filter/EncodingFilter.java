package com.lmh.ph.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/*
 * 字符编码过滤器
 */
@WebFilter("/*")
public class EncodingFilter implements Filter{
    private String encoding = "UTF-8";
    @Override
    public void destroy() {
// TODO Auto-generated method stub
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
		//对于所有请求和响应设置字符编码
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset="+encoding);
		//继续向后执行
        chain.doFilter(request, response);
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}