package desafio.desafio.Models;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "Products")
@AllArgsConstructor
public class Products implements Serializable {
    private static final long serialVersionUID = 3051278784539369028L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    @Column(name="color")
    private String color;
    @Column(name="name")
    private String name;
    @Column(name="addDate")
    private Date addDate;
    @Column(name="price")
    private Float price;
    @Column(name="adminId")
    private Admin adminId;
    @Column(name="categoryId")
    private Category categoryId;
    @Column(name="providerId")
    private Provider providerId;
}
