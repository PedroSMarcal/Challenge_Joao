package desafio.desafio.Controllers;

import desafio.desafio.Models.Commom;
import desafio.desafio.Service.CommomService;
import desafio.desafio.requests.CommomPostRequestBody;
import desafio.desafio.requests.CommomPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("commom")
@RequiredArgsConstructor
public class CommomController {
    @Autowired
    private CommomService commomService;

    @GetMapping
    public ResponseEntity<List<Commom>> listAll(){
        return new ResponseEntity(commomService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<Commom>> FindByName(@RequestParam(required = false) String name){
        return ResponseEntity.ok(commomService.findByName(name));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Commom> FindById(@PathVariable Long id){
        return ResponseEntity.ok(commomService.findById(id));
    };

    @PostMapping
    public ResponseEntity<Commom> addCommomUser(@RequestBody CommomPostRequestBody commomPostRequestBody){
        return new ResponseEntity<>(commomService.addCommomUser(commomPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCommomUser(@PathVariable Long id){
        commomService.deleteCommomUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replaceCommomUser(@RequestBody CommomPutRequestBody commomPutRequestBody){
        commomService.replaceCommomUser(commomPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
