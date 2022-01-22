package desafio.desafio.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminPostRequestBody {
    private String name;
    private String email;
    private String password;
    private Boolean admin;

}