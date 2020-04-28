package space.dubovitsky.portfolio.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan({ "space.dubovitsky.portfolio.controller" })
public class MvcConfiguration implements WebMvcConfigurer {

    /**
     * Устанавливаем View Resolver, который отвечает за то, как нужно отображать данные полученные из модели
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/JSP/"); //! TODO Попробовать в Spring Boot, чтобы не в resources/template хранить вьюшки
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public CommonsMultipartResolver commonsMultipartResolver() { //! Бин для работы с multipartFile, для загрузки бинарных данных через текстовый протокол Http
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        return commonsMultipartResolver;
    }

    /**
     * Все ресурсы, к которым идет обращениене через контроллер, добавляем в исключения
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        registry.addResourceHandler("/media/**").addResourceLocations("/media/");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("/favicon.ico");
    }
}