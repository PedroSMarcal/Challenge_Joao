package desafio.desafio.Service;

import desafio.desafio.Exception.BadRequestException;
import desafio.desafio.Models.Commom;
import desafio.desafio.Repository.CommomRepository;
import desafio.desafio.mapper.CommomMapper;
import desafio.desafio.requests.CommomPostRequestBody;
import desafio.desafio.requests.CommomPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommomService {
    private final CommomRepository commomRepository;

    public List<Commom> listAll(){
        return commomRepository.findAll();
    }

    public List<Commom> findByName(String name){
        return commomRepository.findByName(name);
    };

    public Commom findById(Long id){
        return commomRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Commom User not Found"));

    }

    public Commom addCommomUser(CommomPostRequestBody commomPostRequestBody){
        return commomRepository.save(CommomMapper.INSTANCE.toACommom(commomPostRequestBody));
    }

    public void deleteCommomUser(Long id){
        commomRepository.delete(findById(id));
    }

    public void replaceCommomUser(CommomPutRequestBody commomPutRequestBody){
        Commom savedCommomUser = findById(commomPutRequestBody.getCommomId());
        Commom commomUser = CommomMapper.INSTANCE.toACommom(commomPutRequestBody);
        commomUser.setId(savedCommomUser.getId());
    }
}
