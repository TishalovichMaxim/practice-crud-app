package by.tishalovichm.crudapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    @NotEmpty(message = "User's first name shouldn't be null or empty")
    private String firstName;

    @NotEmpty(message = "User's last name shouldn't be null or empty")
    private String lastName;

    @NotEmpty(message = "User's email shouldn't be null or empty")
    @Email(message = "User's email should be formed as valid email")
    private String email;

}
