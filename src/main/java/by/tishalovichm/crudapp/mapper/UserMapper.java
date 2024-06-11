package by.tishalovichm.crudapp.mapper;

import by.tishalovichm.crudapp.dto.UserDto;
import by.tishalovichm.crudapp.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDto toDto(User user);

    User toUser(UserDto user);

}
