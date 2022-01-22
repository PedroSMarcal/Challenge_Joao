package desafio.desafio.requests;

import lombok.Data;

@Data
public class AdminPutRequestBody {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Boolean admin;
}
