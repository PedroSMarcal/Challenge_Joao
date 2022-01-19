package desafio.desafio.Models;

import lombok.AllArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "Category")
@AllArgsConstructor
public class Category implements Serializable {
    private static final long serialVersionUID = 7136541941448084259L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer category_id;
    private String name;
    private String Description;
}
