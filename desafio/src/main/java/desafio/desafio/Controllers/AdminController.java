package desafio.desafio.Controllers;

import desafio.desafio.Models.Admin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {
    @GetMapping(path = "teste")
    public List<Admin> list(){
        return List.of(new Admin(1, true, "Pedro", "pedro.h.silva.marcal@gmail.com", "teste"), new Admin(1, true, "Pedro", "pedro.h.silva.marcal@gmail.com", "teste"));
    }

}
