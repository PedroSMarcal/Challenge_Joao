package desafio.desafio.Service;

import desafio.desafio.Exception.BadRequestException;
import desafio.desafio.Models.Admin;
import desafio.desafio.Repository.AdminRepository;
import desafio.desafio.mapper.AdminMapper;
import desafio.desafio.requests.AdminPostRequestBody;
import desafio.desafio.requests.AdminPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    public Page<Admin> listAll(Pageable pageable){
        return adminRepository.findAll(pageable);
    }

    public List<Admin> listAllNonPageable() {
        return adminRepository.findAll();
    }

    public Admin findById(Long id){
        return adminRepository.findById(id)
                .orElseThrow(() -> new BadRequestException( "Admin not Found"));

    }

    @Transactional
    public Admin addAdmin(AdminPostRequestBody adminPostRequestBody){
        System.out.println(adminPostRequestBody);
        System.out.println(adminRepository.save(AdminMapper.INSTANCE.toAdmin(adminPostRequestBody)));
        return null;
        // return adminRepository.save(AdminMapper.INSTANCE.toAdmin(adminPostRequestBody));
    }

    public void deleteAdmin(Long id){
        Optional<Admin> admin = adminRepository.findById(id);
        Admin adminToChange = adminRepository.getById(id);
        if (admin.isPresent()){
            adminToChange.setActive(false);
        }
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
