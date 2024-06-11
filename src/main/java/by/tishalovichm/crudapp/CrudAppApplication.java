package by.tishalovichm.crudapp;

import by.tishalovichm.crudapp.mapper.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudAppApplication {

    @Bean
    public UserMapper mapStructUserMapper() {
        return Mappers.getMapper( UserMapper.class );
    }

    public static void main(String[] args) {
        SpringApplication.run(CrudAppApplication.class, args);
    }

}
