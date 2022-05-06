package com.example.redisexample.filter;

import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mirau
 */
@Configuration
public class MyFilterConfig {
    @Bean
    public FilterRegistrationBean<FilterD> perfFilter() {
        FilterRegistrationBean<FilterD> registration = new FilterRegistrationBean<>();
        registration.setFilter(new FilterD());
        registration.setOrder(999);
        registration.addUrlPatterns("/*");
        return registration;
    }

    @Slf4j
    static class FilterD implements Filter {
        AtomicInteger atomic = new AtomicInteger();

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            //获取到用户标识
            String userNo = getUserNo(request);
            //把用户 ID 放到 MDC 上下文中
            MDC.put("userId", userNo);

            LOGGER.info("start do filter D ");
            chain.doFilter(request, response);
            LOGGER.info("end do filter D");

        }

        private String getUserNo(ServletRequest request) {
            String traceId = request.getParameter("traceId");
            return StringUtils.isNotBlank(traceId) ? traceId : "traceId-" + atomic.incrementAndGet();
        }


    }
}