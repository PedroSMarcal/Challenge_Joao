package desafio.desafio.Models;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@Table(name = "CarShop")
public class CarShop implements Serializable {
    public static final long serialVersionUID = -813460447973672321L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer comomId;
    @Column(name="totalValues")
    private Float totalValue;
    @Column(name="pay")
    private Boolean pay;
}
