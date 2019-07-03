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
        webApplicationContext.register(ApplicationConfig.class);
//        System.out.println(webApplicationContext.getBeanDefinitionNames());

        //servletContext.addListener(new ContextLoaderListener(webApplicationContext));

      //  System.out.println("1111: "+webApplicationContext.getBean(ApplicationConfig.class));

        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", dispatcherServlet);
        dynamic.addMapping("/*");
        dynamic.setLoadOnStartup(1);
    }
}
