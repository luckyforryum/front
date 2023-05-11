package ru.kata.spring.boot_security.demo.configs;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.*;
import ru.kata.spring.boot_security.demo.conventer.StringToRoleConverter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ru.kata.spring.boot_security.demo.controller")
public class MvcConfig implements WebMvcConfigurer {
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/"
    };
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

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }


}
