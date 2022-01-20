package desafio.desafio.Models;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "Users")
public class TypeUser implements Serializable {
    public static final long serialVersionUID = -3771610476038939806L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="active")
    private Boolean active;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

    //CONSTRUCTOS
    public TypeUser(){

    }

    public TypeUser(Integer id, Boolean active, String name, String email, String password) {
        this.id = id;
        this.active = active;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    //SETTERS
    public void setId(Integer id) {
        this.id = id;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //GETTERS

    public Integer getId() {
        return this.id;
    }

    public Boolean getActive() {
        return this.active;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    //ToString

    @Override
    public String toString() {
        return "TypeUser{" +
                "id=" + id +
                ", active=" + active +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
