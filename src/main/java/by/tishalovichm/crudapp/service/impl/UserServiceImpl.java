package by.tishalovichm.crudapp.service.impl;

import by.tishalovichm.crudapp.dto.UserDto;
import by.tishalovichm.crudapp.entity.User;
import by.tishalovichm.crudapp.exception.ResourceNotFoundException;
import by.tishalovichm.crudapp.mapper.UserMapper;
import by.tishalovichm.crudapp.repository.UserRepository;
import by.tishalovichm.crudapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper mapper;

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {
        User savedUser = userRepository.save(
                mapper.toUser(user)
        );

        return mapper.toDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long id) {
        User foundUser = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
        return mapper.toDto(foundUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public UserDto updateUser(UserDto user) {
        if (userRepository.existsById(user.getId())) {
            throw new ResourceNotFoundException("User", "id", user.getId());
        }

        User updatedUser = userRepository.save(
                mapper.toUser(user)
        );

        return mapper.toDto(updatedUser);
    }

    @Override
    public void deleteById(Long id) {
        if (userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User", "id", id);
        }

        userRepository.deleteById(id);
    }

}
