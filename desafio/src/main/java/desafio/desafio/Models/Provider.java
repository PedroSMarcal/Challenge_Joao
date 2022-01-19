package desafio.desafio.Models;

import lombok.AllArgsConstructor;

import javax.naming.Name;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "Provider")
@AllArgsConstructor
public class Provider implements Serializable {
    public static final long serialVersionUID = 1001938585210169950L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer provider_id;
    private String name;
}
