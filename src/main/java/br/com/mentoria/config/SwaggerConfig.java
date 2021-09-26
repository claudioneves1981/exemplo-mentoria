package br.com.mentoria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.mentoria.apis"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("exemplo-mentoria")
                .description(buildDescription().toString())
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact("Claudio Neves", "http://github.com/claudioneves1981", "claudio.neves@etec.sp.gov.br"))
                .build();
    }

    private StringBuilder buildDescription(){
        StringBuilder text = new StringBuilder();
        text.append("Um exemplo de aplicaçao Spring Boot REST API e documentada com Swagger");
        text.append("Neste exemplo de skeleton estao sendo utilizadados Spring e Swagger");
        return text;
    }
}
