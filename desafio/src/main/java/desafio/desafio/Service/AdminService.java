package desafio.desafio.Service;

import desafio.desafio.Exception.BadRequestException;
import desafio.desafio.Models.Admin;
import desafio.desafio.Repository.AdminRepository;
import desafio.desafio.mapper.AdminMapper;
import desafio.desafio.requests.AdminPostRequestBody;
import desafio.desafio.requests.AdminPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
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

    public Admin findById(Long id){
        return adminRepository.findById(id)
                .orElseThrow(() -> new BadRequestException( "Admin not Found"));

    }

    @Transactional
    public Admin addAdmin(AdminPostRequestBody adminPostRequestBody){
        return adminRepository.save(AdminMapper.INSTANCE.toAdmin(adminPostRequestBody));
    }

    public void deleteAdmin(Long id){
        adminRepository.delete(findById(id));
    }

    public void replaceAdmin(AdminPutRequestBody adminPutRequestBody){
        Admin savedAdmin = findById(adminPutRequestBody.getAdminId());
        Admin admin = AdminMapper.INSTANCE.toAdmin(adminPutRequestBody);
        admin.setId(savedAdmin.getId());
    }

    public List<Admin> findByName(String name){
        return adminRepository.findByName(name);
    }

}
