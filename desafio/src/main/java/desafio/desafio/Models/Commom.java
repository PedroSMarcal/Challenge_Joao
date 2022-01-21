package desafio.desafio.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "Commom")
public class Commom extends TypeUser implements Serializable {
    public static final long serialVersionUID = -8506743393846541263L;

    private Float credit;

    public Commom(Integer id, Boolean active, String name, String email, String password) {
        super(id, active, name, email, password);
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public Float getCredit() {
        return credit;
    }
}
