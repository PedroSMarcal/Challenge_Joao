package desafio.desafio.Models;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@Table(name = "Commom")
public class Commom extends TypeUser implements Serializable {
    public static final long serialVersionUID = -8506743393846541263L;

    private Float credit;

    //CONSTRUCTORS
    public Commom(){};

    public Commom(Integer id, Boolean active, String name, String email, String password, Float credit) {
        super(id, active, name, email, password);
    }

    // GETTERS AND SETTERS
    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }
}
