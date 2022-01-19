package desafio.desafio.Repository;

import desafio.desafio.Models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDTO extends JpaRepository<Admin, Long> {

}
