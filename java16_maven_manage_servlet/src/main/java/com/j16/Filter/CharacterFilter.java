package com.j16.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @author Master
 */
@WebFilter(value = "/*", initParams = {
        /**
         * 设置启动项名称与值
         */
        @WebInitParam(name = "character", value = "utf-8")
})
public class CharacterFilter implements Filter {

    public String character;

    public CharacterFilter() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        /**
         * 读取配置信息
         */
        character = filterConfig.getInitParameter("character");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        servletRequest.setCharacterEncoding(character);
        servletResponse.setCharacterEncoding(character);
        /**
         * 放行
         */
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
