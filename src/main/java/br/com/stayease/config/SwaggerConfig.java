package br.com.stayease.config;

import com.google.common.base.Predicates;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@NoArgsConstructor
public class SwaggerConfig {
    private StayEasyProperties props;

    @Autowired
    public SwaggerConfig(StayEasyProperties props) {
        this.props = props;
    }


    @Bean
    public ApiInfo moduleApiInfo() {
        return new ApiInfoBuilder()
                .title(props.getTitle())
                .description(props.getDescription())
                .version(props.getVersion())
                .build();
    }

    public String getEndpointsPackage() {
        return props.getEndpointsPackage();
    }

    @Bean
    @DependsOn({"moduleApiInfo"})
    public Docket api(ApiInfo moduleApiInfo) {
        return (new Docket(DocumentationType.SWAGGER_2)).select().apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))).apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.data.rest.webmvc"))).apis(RequestHandlerSelectors.basePackage(this.getEndpointsPackage())).paths(PathSelectors.any()).build().apiInfo(moduleApiInfo);
    }
}
