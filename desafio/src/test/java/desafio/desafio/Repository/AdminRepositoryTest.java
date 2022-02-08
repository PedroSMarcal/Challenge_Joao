package desafio.desafio.Repository;

import desafio.desafio.Models.Admin;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@DisplayName("Test for Admin Repository")
class AdminRepositoryTest {
    @Autowired
    private AdminRepository adminRepository;

    @Test
    @DisplayName("Save admin when Success")
    void save_PersistAdmin_WhenSuccessful(){
        Admin admin = createAdmin();
        Admin savedAdmin = this.adminRepository.save(admin);
        Assertions.assertThat(savedAdmin).isNotNull();
        Assertions.assertThat(savedAdmin.getId()).isNotNull();
        Assertions.assertThat(savedAdmin.getName()).isEqualTo(admin.getName());
    }

    @Test
    @DisplayName("Update admin when Success")
    void update_UpdateAdmin_WhenSuccessful(){
        Admin admin = createAdmin();
        Admin savedAdmin = this.adminRepository.save(admin);

        savedAdmin.setName("Marçal");

        Admin updateAdmin = this.adminRepository.save(savedAdmin);

        Assertions.assertThat(updateAdmin).isNotNull();
        Assertions.assertThat(updateAdmin.getId()).isNotNull();
        Assertions.assertThat(updateAdmin.getName()).isEqualTo(savedAdmin.getName());
    }

    @Test
    @DisplayName("Delete admin when Success")
    void delete_RemoveAdmin_WhenSuccessful(){
        Admin admin = createAdmin();
        Admin savedAdmin = this.adminRepository.save(admin);

        this.adminRepository.delete(savedAdmin);

        Optional<Admin> adminOptional = this.adminRepository.findById(savedAdmin.getId());

        Assertions.assertThat(adminOptional).isEmpty();
    }

    @Test
    @DisplayName("Find By Name admin when Success")
    void FindByName_ReturnListOfAdmin_WhenSuccessful(){
        Admin admin = createAdmin();
        Admin savedAdmin = this.adminRepository.save(admin);

        String name = savedAdmin.getName();

        List<Admin> admins = adminRepository.findByName(name);

        Assertions.assertThat(admins).isNotEmpty();
        Assertions.assertThat(admins).contains(savedAdmin);

    }

    @Test
    @DisplayName("Find By Name return empty List admin when no admin is found")
    void FindByName_ReturnEmptyListOfAdmin_WhenAdminisNotFound(){
        List<Admin> admins = adminRepository.findByName("name");

        Assertions.assertThat(admins).isEmpty();

    }

    private Admin createAdmin(){
        Admin create = new Admin(1, true, "Pedro", "pedro2@gmail.com", "123456", true);
        return create;
    }

}