package desafio.desafio.Controllers;

import desafio.desafio.Repository.AdminDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost/127.0.0.1:5500/Admin")
public class AdminController {
    @Autowired
    AdminDTO adminRepository;

    @PostMapping
}
