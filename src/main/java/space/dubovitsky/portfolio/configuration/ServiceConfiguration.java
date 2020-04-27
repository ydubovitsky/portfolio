package space.dubovitsky.portfolio.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;


@Configuration
@ComponentScan({
        "space.dubovitsky.portfolio.service.impl",
        "space.dubovitsky.portfolio.controller",
        "space.dubovitsky.portfolio.filter",
        "space.dubovitsky.portfolio.listener"})
public class ServiceConfiguration {

    /**
     * Теперь ко всем свойствам можно обращаться через @Value()
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() throws IOException {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocations(new ClassPathResource("application.properties"));
        return configurer;
    }
}
