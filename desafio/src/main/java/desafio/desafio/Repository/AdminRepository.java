package desafio.desafio.Repository;

import desafio.desafio.Models.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Repository
public class AdminRepository {
    public List<Admin> listAll(){
        return List.of(new Admin(1, true, "pedro", "pedro.h.silva.marcal@gmail.com", "123456"),
                new Admin(1, true, "pedro2", "pedro2.h.silva.marcal@gmail.com", "1234562"));
    }

    public ResponseEntity<Admin> getById(int id){
        Admin adminFound = listAll()
                .stream()
                .filter(Admin -> Admin.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not Found"));

        return ResponseEntity.ok(adminFound);
    }

    public Admin addAdmin(Admin admin){
        admin.setId(ThreadLocalRandom.current().nextInt(4, 100000));
        admin.add(admin);
        return admin;
    }

    public void deleteAdmin(int id){
        admin.remove(listAll()
                .stream()
                .findFirst(Admin -> Admin.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not Found")));
    }
}
