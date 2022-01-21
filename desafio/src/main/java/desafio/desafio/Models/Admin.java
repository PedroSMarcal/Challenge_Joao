package desafio.desafio.Models;

import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "Admin")
public class Admin extends TypeUser implements Serializable {
    public static final long serialVersionUID = -3771610476038939806L;


    public Admin(Integer id, Boolean active, String name, String email, String password) {
        super(id, active, name, email, password);
    }
}
