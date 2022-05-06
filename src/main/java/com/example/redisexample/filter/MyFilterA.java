package com.example.redisexample.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author mirau on 2022/4/30.
 * @version 1.0
 */
@Slf4j
@Component
@Order(1)
public class MyFilterA implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("filter A init");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("start do filter A ");
        filterChain.doFilter(servletRequest, servletResponse);
        LOGGER.info("end do filter A");
    }

    @Override
    public void destroy() {
        LOGGER.info("filter A destroy ");
        Filter.super.destroy();
    }
}
