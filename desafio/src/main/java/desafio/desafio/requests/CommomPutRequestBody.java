package desafio.desafio.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CommomPutRequestBody {
    private Long commomId;
    private Boolean active;

    @NotNull
    @NotEmpty(message = "The admin need to be a name")
    private String name;

    @NotNull
    @NotEmpty(message = "The admin need to have a password")
    private String password;

    @NotNull
    @NotEmpty(message = "The admin need to have an credit")
    private Float credit;
}
