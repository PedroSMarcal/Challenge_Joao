package desafio.desafio.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.Name;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "Provider")
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Provider implements Serializable {
    public static final long serialVersionUID = 1001938585210169950L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long providerId;

    @Column(name="name")
    private String name;


}
