package desafio.desafio.Controllers;

import desafio.desafio.Models.Products;
import desafio.desafio.Service.ProductsService;
import desafio.desafio.requests.ProductsPostRequestBody;
import desafio.desafio.requests.ProductsPutRequestBody;
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
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @GetMapping
    public ResponseEntity<Page<Products>> listAll(Pageable pageable){
        return new ResponseEntity(productsService.listAll(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<List<Products>> FindByName(@RequestParam(required = false) String name){
        return ResponseEntity.ok(productsService.findByName(name));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Products> FindById(@PathVariable Long id){
        return ResponseEntity.ok(productsService.findById(id));
    };

    @PostMapping
    public ResponseEntity<Products> addCategory(@RequestBody @Valid ProductsPostRequestBody productsPostRequestBody){
        return new ResponseEntity<>(productsService.addProducts(productsPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        productsService.deleteProducts(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replaceCategory(@RequestBody @Valid ProductsPutRequestBody productsPutRequestBody){
        productsService.replaceProducts(productsPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
