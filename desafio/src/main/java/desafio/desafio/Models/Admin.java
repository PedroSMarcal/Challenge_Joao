package desafio.desafio.Models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Table(name = "Admin")
@Entity
public class Admin extends TypeUser implements Serializable {
    public static final long serialVersionUID = -3771610476038939806L;

    private Boolean admin;

    public Admin(Integer adminId, Boolean active, String name, String email, String password) {
        super(adminId, active, name, email, password);
    }

}
