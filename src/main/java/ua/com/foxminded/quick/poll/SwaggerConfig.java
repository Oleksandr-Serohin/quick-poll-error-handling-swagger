package ua.com.foxminded.quick.poll;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.models.dto.builder.ApiInfoBuilder;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;

@Configuration
@EnableSwagger
public class SwaggerConfig {

    @Inject
    SpringSwaggerConfig springSwaggerConfig;

    @Bean
    public SwaggerSpringMvcPlugin springMvcPlugin(){
        SwaggerSpringMvcPlugin springMvcPlugin = new SwaggerSpringMvcPlugin(this.springSwaggerConfig);

        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("Quick poll RESET API")
                .description("QuickPoll Api for creating and managing polls\"")
                .termsOfServiceUrl("http://example.com/terms-of-service")
                .contact("info@example.com")
                .license("MIT License")
                .licenseUrl("http://opensource.org/licenses/MIT")
                .build();
        springMvcPlugin.apiInfo(apiInfo).apiVersion("1.0");
        springMvcPlugin.useDefaultResponseMessages(false);
        return springMvcPlugin;

    }


}


