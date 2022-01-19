package desafio.desafio.Models;

import lombok.AllArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@AllArgsConstructor
@Table(name = "Commom")
public class Commom extends TypeUser implements Serializable {
    public static final long serialVersionUID = -8506743393846541263L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commom_id;
    private Float integer;
}
