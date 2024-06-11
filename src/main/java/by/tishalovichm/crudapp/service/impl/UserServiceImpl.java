package by.tishalovichm.crudapp.service.impl;

import by.tishalovichm.crudapp.dto.UserDto;
import by.tishalovichm.crudapp.entity.User;
import by.tishalovichm.crudapp.repository.UserRepository;
import by.tishalovichm.crudapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ModelMapper mapper;

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {
        User savedUser = userRepository.save(
                mapper.map(user, User.class)
        );

        return mapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto getUserById(Long id) {
        User foundUser = userRepository.findById(id).orElseThrow();
        return mapper.map(foundUser, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> mapper.map(user, UserDto.class))
                .toList();
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User updatedUser = userRepository.save(
                mapper.map(user, User.class)
        );

        return mapper.map(updatedUser, UserDto.class);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
