package desafio.desafio.Repository;

import desafio.desafio.Models.Commom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommomRepository extends JpaRepository<Commom, Long> {

}
