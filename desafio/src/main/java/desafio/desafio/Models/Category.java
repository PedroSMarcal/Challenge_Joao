package desafio.desafio.Models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "Category")
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Category implements Serializable {
    private static final long serialVersionUID = 7136541941448084259L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String Description;
}
