package desafio.desafio.requests;

import lombok.Data;

import javax.persistence.Column;

@Data
public class AdminPostRequestBody {
    private String name;
    private String email;
    private String password;
    private Boolean admin;
}
