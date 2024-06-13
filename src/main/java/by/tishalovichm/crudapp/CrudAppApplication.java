package by.tishalovichm.crudapp;

import by.tishalovichm.crudapp.mapper.UserMapper;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Sring Boot REST API Documentation",
                description = "Spring Boot REST API Documentation",
                version = "v1.0",
                contact = @Contact(
                        email = "tishalovichm@gmail.com",
                        name = "Tishalovich Maxim"
                ),
                license = @License(
                        name = "MIT"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring Boot User Management Documentation",
                url = "https://spring.io/projects/spring-boot"
        )
)
public class CrudAppApplication {

    @Bean
    public UserMapper mapStructUserMapper() {
        return Mappers.getMapper( UserMapper.class );
    }

    public static void main(String[] args) {
        SpringApplication.run(CrudAppApplication.class, args);
    }

}
