package desafio.desafio.Service;

import desafio.desafio.Exception.BadRequestException;
import desafio.desafio.Models.Provider;
import desafio.desafio.Repository.ProviderRepository;
import desafio.desafio.mapper.ProviderMapper;
import desafio.desafio.requests.ProviderPostRequestBody;
import desafio.desafio.requests.ProviderPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderService {
    private final ProviderRepository providerRepository;

    public Page<Provider> listAll(Pageable pageable){
        return providerRepository.findAll(pageable);
    }

    public List<Provider> findByName(String name){
        return providerRepository.findByName(name);
    }

    public Provider findById(Long id){
        return providerRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Provider not Found"));

    }

    public Provider addProvider(ProviderPostRequestBody providerPostRequestBody){
        return providerRepository.save(ProviderMapper.INSTANCE.toPostProvider(providerPostRequestBody));
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

