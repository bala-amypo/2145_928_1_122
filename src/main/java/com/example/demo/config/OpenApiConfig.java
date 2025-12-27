// package com.example.demo.config;

// import io.swagger.v3.oas.models.OpenAPI;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class OpenApiConfig {

//     @Bean
//     public OpenAPI openAPI() {
//         return new OpenAPI();
//     }
// }
package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Influencer Campaign ROI Tracker API")
                        .description("Spring Boot REST API with JWT Authentication")
                        .version("1.0.0"))
                .servers(List.of(
                        new Server()
                                .url("https://9159.408procr.amypo.ai/")
                                .description("Production Server"),
                        new Server()
                                .url("http://localhost:9001")
                                .description("Local Development Server")
                ));
    }
}
