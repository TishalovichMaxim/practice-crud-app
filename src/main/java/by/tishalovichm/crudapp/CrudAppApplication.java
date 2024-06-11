package by.tishalovichm.crudapp;

import by.tishalovichm.crudapp.mapper.MapStructUserMapper;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudAppApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public MapStructUserMapper mapStructUserMapper() {
        return Mappers.getMapper( MapStructUserMapper.class );
    }

    public static void main(String[] args) {
        SpringApplication.run(CrudAppApplication.class, args);
    }

}
