package desafio.desafio.Models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "Products")
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Products implements Serializable {
    private static final long serialVersionUID = 3051278784539369028L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name="color")
    private String color;

    @Column(name="name")
    private String name;

    @Column(name="addDate")
    private Date addDate;

    @Column(name="price")
    private Float price;

    @ManyToOne
    @JoinColumn(name = "adminId")
    private Admin adminId;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category categoryId;

    @ManyToOne
    @JoinColumn(name = "providerId")
    private Provider providerId;
}
