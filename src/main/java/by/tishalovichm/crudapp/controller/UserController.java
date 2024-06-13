package by.tishalovichm.crudapp.controller;

import by.tishalovichm.crudapp.dto.UserDto;
import by.tishalovichm.crudapp.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(
        name = "CRUD rest API for user entity",
        description = "This API contains CRUD functionality for users manipulating"
)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Operation(
        summary = "Create new user",
        description = "Used to insert new user to a database"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "User successfully added"
                    ),
            }
    )
    @PostMapping("")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
        UserDto createdUserDto = userService.createUser(user);

        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Retrieving user by id",
            description = "Used to get used by id from database"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "User successfully found"
                    ),
            }
    )
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Operation(
            summary = "Retrieving all users",
            description = "Used to get all users from database"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "All users are retrieved"
                    ),
            }
    )
    @GetMapping("")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Operation(
            summary = "Update a user",
            description = "Used to update user with certain id from database"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "User successfully updated"
                    ),
            }
    )
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable Long id, @Valid @RequestBody UserDto user) {

        user.setId(id);
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @Operation(
            summary = "Delete a user",
            description = "Used to delete a user by id"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "User successfully deleted"
                    ),
            }
    )
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
