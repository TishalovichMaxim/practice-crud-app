package by.tishalovichm.crudapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "UserDto information"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    @Schema(
            description = "User first name"
    )
    @NotEmpty(message = "User's first name shouldn't be null or empty")
    private String firstName;

    @Schema(
            description = "User last name"
    )
    @NotEmpty(message = "User's last name shouldn't be null or empty")
    private String lastName;

    @Schema(
            description = "User email address"
    )
    @NotEmpty(message = "User's email shouldn't be null or empty")
    @Email(message = "User's email should be formed as valid email")
    private String email;

}
