package desafio.desafio.Controllers;

import desafio.desafio.Models.Admin;
import desafio.desafio.Service.AdminService;
import desafio.desafio.requests.AdminPostRequestBody;
import desafio.desafio.requests.AdminPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {
    @Autowired
    private final AdminService adminService;


    @GetMapping
    public ResponseEntity<List<Admin>>listAll(){
        return new ResponseEntity<>(adminService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Admin> FindById(@PathVariable long id){
        return ResponseEntity.ok(adminService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin){
        return new ResponseEntity<>(adminService.addAdmin(admin), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable int id){
        adminService.deleteAdmin(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replaceAdmin(@RequestBody Admin admin){
        adminService.replaceAdmin(admin);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
