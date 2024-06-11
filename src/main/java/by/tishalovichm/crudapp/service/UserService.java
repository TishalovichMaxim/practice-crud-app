package by.tishalovichm.crudapp.service;

import by.tishalovichm.crudapp.dto.UserDto;
import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteById(Long id);
}
