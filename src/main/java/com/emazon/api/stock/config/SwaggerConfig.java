package com.emazon.api.stock.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI cumOpenApi(@Value("0.0.1-SNAPSHOT")String appVersion){
        return new OpenAPI()
                .info(new Info()
                        .title("Stock")
                        .version(appVersion)
                        .description("Amazon stock management system"));
    }

}
