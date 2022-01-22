package desafio.desafio.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "CarShop")
public class CarShop implements Serializable {
    public static final long serialVersionUID = -813460447973672321L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carShopId;
    @Column(name="totalValues")
    private Float totalValue;
    @Column(name="pay")
    private Boolean pay;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Products products;
}


