package desafio.desafio.Controllers;

import desafio.desafio.Models.Provider;
import desafio.desafio.Service.ProviderService;
import desafio.desafio.requests.ProviderPostRequestBody;
import desafio.desafio.requests.ProviderPutRequestBody;
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
@RequestMapping("provider")
@RequiredArgsConstructor
public class ProviderController {
    @Autowired
    private final ProviderService providerService;

    @GetMapping
    public ResponseEntity<Page<Provider>> listAll(Pageable pageable){
        return new ResponseEntity<>(providerService.listAll(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<List<Provider>> FindByName(@RequestParam(required = false)  String name){
        return ResponseEntity.ok(providerService.findByName(name));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Provider> FindById(@PathVariable Long id){
        return ResponseEntity.ok(providerService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Provider> addProvider(@RequestBody @Valid ProviderPostRequestBody providerPostRequestBody){
        return new ResponseEntity<>(providerService.addProvider(providerPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteProvider(@PathVariable Long id){
        providerService.deleteProvider(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replaceProvider(@RequestBody @Valid ProviderPutRequestBody providerPutRequestBody){
        providerService.replaceProvider(providerPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
