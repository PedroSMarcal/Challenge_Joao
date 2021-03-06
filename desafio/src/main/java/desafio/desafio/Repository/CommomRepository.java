package desafio.desafio.Repository;

import desafio.desafio.Models.Commom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommomRepository extends JpaRepository<Commom, Long> {

    List<Commom> findByName(String name);
}
