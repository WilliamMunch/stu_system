package com.school.stu_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: stu_system
 * @description: Swagger2 配置
 * @author: William Munch
 * @create: 2019-07-10 16:54
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("学生管理系统项目_接口文档")
                        .description("学生管理系统接口测试文档")
                        .contact(new Contact("William Munch", "https://github.com/WilliamMunch", "wy995053971@163.com"))
                        .version("v1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.school.stu_system.controller"))
                .paths(PathSelectors.any())
                .build();
    }


}
