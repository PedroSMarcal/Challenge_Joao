package desafio.desafio.Controllers;

import desafio.desafio.Models.Admin;
import desafio.desafio.Service.AdminService;
import desafio.desafio.requests.AdminPostRequestBody;
import desafio.desafio.requests.AdminPutRequestBody;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {
    @Autowired
    private final AdminService adminService;

    @GetMapping
    public ResponseEntity<Page<Admin>>list(Pageable pageable){
        return ResponseEntity.ok(adminService.listAll(pageable));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Admin>>listAll(){
        return ResponseEntity.ok(adminService.listAllNonPageable());
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<Admin> FindById(@PathVariable Long id){
        return ResponseEntity.ok(adminService.findById(id));
    }

    @GetMapping(path = "/getName/{name}")
    public ResponseEntity<List<Admin>> FindByName(@RequestParam(required = false) String name){
        return ResponseEntity.ok(adminService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Admin> addAdmin(@RequestBody AdminPostRequestBody adminPostRequestBody){
        return new ResponseEntity<>(adminService.addAdmin(adminPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id){
        adminService.deleteAdmin(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replaceAdmin(@RequestBody @Valid AdminPutRequestBody adminPutRequestBody){
        adminService.replaceAdmin(adminPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
