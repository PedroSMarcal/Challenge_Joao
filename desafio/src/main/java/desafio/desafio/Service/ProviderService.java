package desafio.desafio.Service;

import desafio.desafio.Models.Provider;
import desafio.desafio.Repository.ProviderRepository;
import desafio.desafio.mapper.ProviderMapper;
import desafio.desafio.requests.ProviderPostRequestBody;
import desafio.desafio.requests.ProviderPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderService {
    private final ProviderRepository providerRepository;

    public List<Provider> listAll(){
        return providerRepository.findAll();
    }

    public Provider findById(Long id){
        return providerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provider not Found"));

    }

    public Provider addProvider(ProviderPostRequestBody providerPostRequestBody){
        return providerRepository.save(ProviderMapper.INSTANCE.toAProvider(providerPostRequestBody));
    }

    public void deleteProvider(Long id){
        providerRepository.delete(findById(id));
    }

    public void replaceProvider(ProviderPutRequestBody providerPutRequestBody){
        Provider savedProvider = findById(providerPutRequestBody.getProviderId());
        Provider provider = ProviderMapper.INSTANCE.toAProvider(providerPutRequestBody);
        provider.setProviderId(savedProvider.getProviderId());
    }

}

