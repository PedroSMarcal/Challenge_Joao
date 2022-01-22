package desafio.desafio.Controllers;

import desafio.desafio.Models.Products;
import desafio.desafio.Service.ProductsService;
import desafio.desafio.requests.ProductsPostRequestBody;
import desafio.desafio.requests.ProductsPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @GetMapping
    public ResponseEntity<List<Products>> listAll(){
        return new ResponseEntity(productsService.listAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Products>> findById(@RequestParam String name){
        return ResponseEntity.ok(productsService.findByName(name));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Products> FindById(@PathVariable Long id){
        return ResponseEntity.ok(productsService.findById(id));
    };

    @PostMapping
    public ResponseEntity<Products> addCategory(@RequestBody ProductsPostRequestBody productsPostRequestBody){
        return new ResponseEntity<>(productsService.addProducts(productsPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        productsService.deleteProducts(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replaceCategory(@RequestBody ProductsPutRequestBody productsPutRequestBody){
        productsService.replaceProducts(productsPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
