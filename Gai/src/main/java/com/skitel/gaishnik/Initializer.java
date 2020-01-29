package com.skitel.gaishnik;

import com.skitel.gaishnik.configs.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class Initializer implements WebApplicationInitializer  {

    private final static String DISPATCHER = "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebConfig.class);
        servletContext.addListener(new ContextLoaderListener(ctx));

        DispatcherServlet dispatcherServlet = new DispatcherServlet(ctx);
        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER, dispatcherServlet);
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");

    }
}
