package desafio.desafio.requests;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AdminPutRequestBody {

    private Long adminId;

    private Boolean active;

    @NotNull
    @NotEmpty(message = "The admin need to be a name")
    private String name;

    @Email
    @NotNull
    @NotEmpty(message = "The admin need to be an email")
    private String email;

    @NotNull
    @NotEmpty(message = "The admin need to have a password")
    private String password;

    private Boolean admin;
}
