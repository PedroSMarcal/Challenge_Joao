package desafio.desafio.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ProviderPostRequestBody {

    @NotEmpty(message = "Must Have an name")
    private String name;
}
