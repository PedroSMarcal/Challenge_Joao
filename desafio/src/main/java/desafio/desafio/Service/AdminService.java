package desafio.desafio.Service;

import desafio.desafio.Models.Admin;
import desafio.desafio.Repository.AdminRepository;
import desafio.desafio.requests.AdminPostRequestBody;
import desafio.desafio.requests.AdminPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    public List<Admin> listAll(){
        return adminRepository.findAll();
    }

    public Admin findById(long id){
        return adminRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Admin not Found"));

    }

    public Admin addAdmin(Admin admin){
            adminRepository.save(admin);
            return admin;
    }

    public void deleteAdmin(long id){
        adminRepository.delete(findById(id));
    }

    public ResponseEntity<Admin> replaceAdmin(Admin admin){
        Optional<Admin> IdValuate = adminRepository.findById(admin.getId());
        if (!IdValuate.isPresent()){
            return null;
        }
        adminRepository.save(admin);
        return ResponseEntity.ok(admin);

    }

}
