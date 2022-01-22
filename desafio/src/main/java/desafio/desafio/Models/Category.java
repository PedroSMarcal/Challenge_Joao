package desafio.desafio.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "Category")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category implements Serializable {
    private static final long serialVersionUID = 7136541941448084259L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String Description;
}
