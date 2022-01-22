package desafio.desafio.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "Commom")
@Entity
@NoArgsConstructor
public class Commom extends TypeUser implements Serializable {
    public static final long serialVersionUID = -8506743393846541263L;

    private Float credit;

    public Commom(Integer CommomId, Boolean active, String name, String email, String password) {
        super(CommomId, active, name, email, password);
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public Float getCredit() {
        return credit;
    }
}
