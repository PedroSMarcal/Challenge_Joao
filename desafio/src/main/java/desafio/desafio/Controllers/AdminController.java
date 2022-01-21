package desafio.desafio.Controllers;

import desafio.desafio.Models.Admin;
import desafio.desafio.Models.TypeUser;
import desafio.desafio.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private final AdminRepository adminRepository;

    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @GetMapping
    public ResponseEntity<List<Admin>>listAll(){
        return new ResponseEntity<>(adminRepository.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Admin> FindById(@PathVariable int id){
        return adminRepository.getById(id);
    }

    @PostMapping
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin){
        return ResponseEntity.ok(adminRepository.addAdmin(admin));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable int id){
        adminRepository.deleteAdmin(id)
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
