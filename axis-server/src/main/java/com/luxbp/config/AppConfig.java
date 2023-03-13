package com.luxbp.config;

import org.apache.axis.transport.http.AdminServlet;
import org.apache.axis.transport.http.AxisHTTPSessionListener;
import org.apache.axis.transport.http.AxisServlet;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ServletRegistrationBean<AxisServlet> axisServlet() {
        AxisServlet servlet = new AxisServlet();
        return new ServletRegistrationBean<>(servlet, "/servlet/AxisServlet", "/services/*", "/axis/services/*");
    }

    @Bean
    public ServletRegistrationBean<AdminServlet> axisAdminServlet() {
        AdminServlet servlet = new AdminServlet();
        ServletRegistrationBean<AdminServlet> adminServletBean = new ServletRegistrationBean<>(servlet);
        adminServletBean.setLoadOnStartup(100);
        return adminServletBean;
    }

    @Bean
    public ServletListenerRegistrationBean<AxisHTTPSessionListener> axisSessionListener() {
        AxisHTTPSessionListener sessionListener = new AxisHTTPSessionListener();
        return new ServletListenerRegistrationBean<>(sessionListener);
    }
}