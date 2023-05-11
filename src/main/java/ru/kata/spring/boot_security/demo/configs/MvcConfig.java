package ru.kata.spring.boot_security.demo.configs;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.*;
import ru.kata.spring.boot_security.demo.Conventer.StringToRoleConverter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ru.kata.spring.boot_security.demo.controller")
public class MvcConfig implements WebMvcConfigurer {
    private final StringToRoleConverter stringArrayToRoleListConverter;
    public MvcConfig(StringToRoleConverter stringArrayToRoleListConverter) {
        this.stringArrayToRoleListConverter = stringArrayToRoleListConverter;
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user").setViewName("user");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringArrayToRoleListConverter);
    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedMethods("GET", "POST", "PUT", "DELETE")
//                .allowedHeaders("*")
//                .allowCredentials(true)
//                .maxAge(3600);
//    }



}
