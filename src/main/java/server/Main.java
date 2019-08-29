package server;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class Main implements WebApplicationInitializer {


    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webApplicationContext=new AnnotationConfigWebApplicationContext();
        // webApplicationContext.register(ApplicationConfig.class);
        webApplicationContext.scan("server");
//        System.out.println(webApplicationContext.getBeanDefinitionNames());

        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", dispatcherServlet);
        dynamic.addMapping("/home");
        dynamic.setLoadOnStartup(1);


        AnnotationConfigWebApplicationContext webApplicationContext2 = new AnnotationConfigWebApplicationContext();
        // webApplicationContext.register(ApplicationConfig.class);
        webApplicationContext2.scan("controllers");
//        System.out.println(webApplicationContext.getBeanDefinitionNames());

        DispatcherServlet dispatcherServlet2 = new DispatcherServlet(webApplicationContext2);
        ServletRegistration.Dynamic dynamic2 = servletContext.addServlet("dispatcher2", dispatcherServlet2);
        dynamic2.addMapping("/hi");
        dynamic2.setLoadOnStartup(1);
    }
}
