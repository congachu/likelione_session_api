package likelion.kmu.session.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // 허용된 Origin
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE") // 허용된 Http Methods
                .allowedHeaders("*") // 허용된 Header
                .exposedHeaders("*") // 허용된 Header 값
                .maxAge(3600); // request 캐싱 시간
    }
}
