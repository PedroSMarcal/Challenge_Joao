package desafio.desafio.Models;

import lombok.AllArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@AllArgsConstructor
@Table(name = "CarShop")
public class CarShop implements Serializable {
    public static final long serialVersionUID = -813460447973672321L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commom_id;
    private Float TotalValue;
    private Boolean pay;
}
