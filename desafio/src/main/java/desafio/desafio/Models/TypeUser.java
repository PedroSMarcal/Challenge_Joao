package desafio.desafio.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Table(name = "Users")
@NoArgsConstructor
@MappedSuperclass
public abstract class TypeUser implements Serializable {
    public static final long serialVersionUID = -3771610476038939806L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name="active")
    private Boolean active;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
}
