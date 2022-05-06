package com.example.redisexample.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
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
public class MyFilterB implements Filter, Ordered {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("filter B init");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("start do filter B ");
        filterChain.doFilter(servletRequest, servletResponse);
        LOGGER.info("end do filter B");
    }

    @Override
    public void destroy() {
        LOGGER.info("filter B destroy ");
        Filter.super.destroy();
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
