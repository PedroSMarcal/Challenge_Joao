package desafio.desafio.Controllers;

import desafio.desafio.Models.Category;
import desafio.desafio.Service.CategoryService;
import desafio.desafio.requests.CategoryPostRequestBody;
import desafio.desafio.requests.CategoryPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("provider")
@RequiredArgsConstructor
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> listAll(){
        return new ResponseEntity(categoryService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Category> FindById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.findById(id));
    };

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody CategoryPostRequestBody categoryPostRequestBody){
        return new ResponseEntity<>(categoryService.addCategory(categoryPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replaceCategory(@RequestBody CategoryPutRequestBody categoryPutRequestBody){
        categoryService.replaceCategory(categoryPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
