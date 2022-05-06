package com.example.redisexample.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

@Configuration
@EnableSwagger2
@Slf4j
public class Swagger2Config {

    @Value("${openSwagger:true}")
    private boolean openSwagger;

    @PostConstruct
    private void init() {
        LOGGER.info("开启swagger:{}", openSwagger);
    }

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("public文档")
                .enable(openSwagger)
//                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
//                .apis(RequestHandlerSelectors.basePackage("com.example"))
                .paths(PathSelectors.any())
//                .paths(PathSelectors.ant("/demo/*"))
                .build()
                .pathMapping("/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("这是标题")
                .description("接口文档")
                .termsOfServiceUrl("http://javainuse.com")
                .version("1.0").build();
    }
}