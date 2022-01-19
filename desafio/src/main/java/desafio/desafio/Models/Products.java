package desafio.desafio.Models;

import lombok.AllArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "Products")
@AllArgsConstructor
public class Products implements Serializable {
    private static final long serialVersionUID = 3051278784539369028L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;
    private String Color, Name;
    private Date add_date;
    private Float Price;
    private Admin admin_id;
    private Category category_id;
    private Provider provider_id;
}
