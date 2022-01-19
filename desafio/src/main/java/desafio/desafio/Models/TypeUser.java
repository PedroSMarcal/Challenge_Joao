package desafio.desafio.Models;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "Users")
public class TypeUser implements Serializable {
    public static final long serialVersionUID = -3771610476038939806L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean active;
    private String name;
    private String email;
    private String Password;
}
