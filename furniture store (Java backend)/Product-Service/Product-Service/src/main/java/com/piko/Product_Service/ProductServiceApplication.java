package com.piko.Product_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")  // Applies CORS to all endpoints
//                        .allowedOrigins("http://localhost:3000")  // Replace with your Next.js URL
//                        .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow specific HTTP methods
//                        .allowedHeaders("*")  // Allow all headers
//                        .allowCredentials(true);  // Allow cookies if needed
//            }
//        };
//    }
}
