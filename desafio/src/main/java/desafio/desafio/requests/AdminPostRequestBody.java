package desafio.desafio.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminPostRequestBody {

    private Boolean active;

    @NotEmpty(message = "The admin need to be a name")
    private String name;

    @Email
    @NotEmpty(message = "The admin need to be an email")
    private String email;

    @NotEmpty(message = "The admin need to have a password")
    private String password;


    private Boolean admin;

}