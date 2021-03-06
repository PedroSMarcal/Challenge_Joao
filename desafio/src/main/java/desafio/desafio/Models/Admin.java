package desafio.desafio.Models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Table(name = "Admin")
@Entity
public class Admin extends TypeUser implements Serializable {
    public static final long serialVersionUID = -3771610476038939806L;

    private Boolean admin;

    public Admin(long adminId, Boolean active, String name, String email, String password, Boolean admin) {
        super(adminId, active, name, email, password);
    }


}

