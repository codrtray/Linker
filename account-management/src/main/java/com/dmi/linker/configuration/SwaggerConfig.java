package com.dmi.linker.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACT
            = new Contact(
            "Dmitry",
            "https://github.com/codrtray",
            "dmirtray@gmail.com");
    public static final ApiInfo DEFAULT
            = new ApiInfo(
            "Linker Documentation",
            "Linker api Documentation",
            "1.0",
            "urn:tos",
            DEFAULT_CONTACT,
            "Apache 2.0",
            "http://www.apache.org/licenses/LICENSE-2.0",
            new ArrayList<>());

    final Set<String> produces_and_consumers = Set.of("application/json", "application/xml");

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT)
                .produces(produces_and_consumers)
                .consumes(produces_and_consumers);
    }

}
