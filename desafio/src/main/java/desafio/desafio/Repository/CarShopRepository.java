package desafio.desafio.Repository;

import desafio.desafio.Models.CarShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarShopRepository extends JpaRepository<CarShop, Long> {
}
