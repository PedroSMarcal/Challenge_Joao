package desafio.desafio.Controllers;

import desafio.desafio.Models.CarShop;
import desafio.desafio.Service.CarShopService;
import desafio.desafio.requests.CarShopPostRequestBody;
import desafio.desafio.requests.CarShopPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carshop")
@RequiredArgsConstructor
public class CarShopController {
    @Autowired
    private CarShopService carShopService;

    @GetMapping
    public ResponseEntity<List<CarShop>> listAll(){
        return new ResponseEntity(carShopService.listAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CarShop>> findByName(@RequestParam String name){
        return ResponseEntity.ok(carShopService.findByName(name));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CarShop> FindById(@PathVariable Long id){
        return ResponseEntity.ok(carShopService.findById(id));
    };

    @PostMapping
    public ResponseEntity<CarShop> addCarShop(@RequestBody CarShopPostRequestBody carShopPostRequestBody){
        return new ResponseEntity<>(carShopService.addCarShop(carShopPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCarShop(@PathVariable Long id){
        carShopService.deleteCarShop(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replaceCarShop(@RequestBody CarShopPutRequestBody carShopPutRequestBody){
        carShopService.replaceCarShop(carShopPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
