package desafio.desafio.Service;

import desafio.desafio.Models.CarShop;
import desafio.desafio.Repository.CarShopRepository;
import desafio.desafio.mapper.CarShopMapper;
import desafio.desafio.requests.CarShopPostRequestBody;
import desafio.desafio.requests.CarShopPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarShopService {
    private final CarShopRepository carShopRepository;

    public List<CarShop> listAll(){
        return carShopRepository.findAll();
    }

    public List<CarShop> findByName(String name){
        return carShopRepository.findByName(name);
    }

    public CarShop findById(Long id){
        return carShopRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category not Found"));

    }

    public CarShop addCarShop(CarShopPostRequestBody carShopPostRequestBody){
        return carShopRepository.save(CarShopMapper.INSTANCE.toCarShop(carShopPostRequestBody));
    }

    public void deleteCarShop(Long id){
        carShopRepository.delete(findById(id));
    }

    public void replaceCarShop(CarShopPutRequestBody carShopPutRequestBody){
        CarShop savedCarShop = findById(carShopPutRequestBody.getCarShopId());
        CarShop carShop = CarShopMapper.INSTANCE.toCarShop(carShopPutRequestBody);
        savedCarShop.setCarShopId(carShop.getCarShopId());
    }
}
