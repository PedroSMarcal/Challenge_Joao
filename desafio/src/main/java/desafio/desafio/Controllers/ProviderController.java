package desafio.desafio.Controllers;

import desafio.desafio.Models.Provider;
import desafio.desafio.Service.ProviderService;
import desafio.desafio.requests.ProviderPostRequestBody;
import desafio.desafio.requests.ProviderPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("provider")
@RequiredArgsConstructor
public class ProviderController {
    @Autowired
    private final ProviderService providerService;

    @GetMapping
    public ResponseEntity<List<Provider>> listAll(){
        return new ResponseEntity<>(providerService.listAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Provider>> findByName(@RequestParam String name){
        return ResponseEntity.ok(providerService.findByName(name));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Provider> FindById(@PathVariable Long id){
        return ResponseEntity.ok(providerService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Provider> addProvider(@RequestBody ProviderPostRequestBody providerPostRequestBody){
        return new ResponseEntity<>(providerService.addProvider(providerPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteProvider(@PathVariable Long id){
        providerService.deleteProvider(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replaceProvider(@RequestBody ProviderPutRequestBody providerPutRequestBody){
        providerService.replaceProvider(providerPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
