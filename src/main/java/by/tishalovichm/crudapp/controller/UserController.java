package by.tishalovichm.crudapp.controller;

import by.tishalovichm.crudapp.dto.UserDto;
import by.tishalovichm.crudapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<UserDto> createUserDto(@RequestBody UserDto user) {
        UserDto createdUserDto = userService.createUser(user);

        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserDto(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<UserDto>> getAllUserDtos() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUserDto(@PathVariable Long id, @RequestBody UserDto user) {
        user.setId(id);
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserDto(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
