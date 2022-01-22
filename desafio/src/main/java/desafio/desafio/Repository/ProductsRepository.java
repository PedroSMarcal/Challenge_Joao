package desafio.desafio.Repository;

import desafio.desafio.Models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Long> {

    List<Products> findByName(String name);
}
