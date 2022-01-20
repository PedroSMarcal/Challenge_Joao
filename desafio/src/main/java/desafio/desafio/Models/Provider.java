package desafio.desafio.Models;

import lombok.AllArgsConstructor;

import javax.naming.Name;
import javax.persistence.*;
import java.io.Serializable;

@Table(name = "Provider")
@AllArgsConstructor
public class Provider implements Serializable {
    public static final long serialVersionUID = 1001938585210169950L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer providerId;
    @Column(name="name")
    private String name;
}