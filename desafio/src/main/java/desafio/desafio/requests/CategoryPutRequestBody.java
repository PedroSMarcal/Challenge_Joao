package desafio.desafio.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CategoryPutRequestBody {
    private Long categoryId;

    @NotNull
    @NotEmpty(message = "The admin need to be a name")
    private String name;

    @NotNull
    @NotEmpty(message = "The admin need to be a description")
    private String Description;
}
