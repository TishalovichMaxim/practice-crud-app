package by.tishalovichm.crudapp.service.impl;

import by.tishalovichm.crudapp.dto.UserDto;
import by.tishalovichm.crudapp.entity.User;
import by.tishalovichm.crudapp.mapper.UserMapper;
import by.tishalovichm.crudapp.repository.UserRepository;
import by.tishalovichm.crudapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {
        User savedUser = userRepository.save(
                userMapper.toUser(user)
        );

        return userMapper.toDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long id) {
        User foundUser = userRepository.findById(id).orElseThrow();
        return userMapper.toDto(foundUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User updatedUser = userRepository.save(
                userMapper.toUser(user)
        );

        return userMapper.toDto(updatedUser);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
