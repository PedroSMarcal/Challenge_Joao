package desafio.desafio.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ProviderPutRequestBody {
    private Long providerId;

    @NotNull
    @NotEmpty(message = "Must Have a name")
    private String name;
}
