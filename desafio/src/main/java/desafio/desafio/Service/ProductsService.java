package desafio.desafio.Service;

import desafio.desafio.Models.Products;
import desafio.desafio.Repository.ProductsRepository;
import desafio.desafio.mapper.ProductsMapper;
import desafio.desafio.requests.ProductsPostRequestBody;
import desafio.desafio.requests.ProductsPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository productsRepository;

    public List<Products> listAll(){
        return productsRepository.findAll();
    }

    public Products findById(Long id){
        return productsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Commom User not Found"));

    }

    public Products addProducts(ProductsPostRequestBody productsPostRequestBody){
        return productsRepository.save(ProductsMapper.INSTANCE.toProduct(productsPostRequestBody));
    }

    public void deleteProducts(Long id){
        productsRepository.delete(findById(id));
    }

    public void replaceProducts(ProductsPutRequestBody productsPutRequestBody){
        Products savedCommomUser = findById(productsPutRequestBody.getProductId());
        Products commomUser = ProductsMapper.INSTANCE.toProduct(productsPutRequestBody);
        commomUser.setProductId(savedCommomUser.getProductId());
    }
}
