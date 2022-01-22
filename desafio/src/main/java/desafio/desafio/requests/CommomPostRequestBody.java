package desafio.desafio.requests;

import lombok.Data;

@Data
public class CommomPostRequestBody {
    private Boolean active;
    private String name;
    private String password;
    private Float credit;
}
