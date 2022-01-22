package desafio.desafio.requests;

import lombok.Data;

@Data
public class ProviderPutRequestBody {
    private Long providerId;
    private String name;
}
