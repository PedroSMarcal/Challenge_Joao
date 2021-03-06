package desafio.desafio.Service;

import desafio.desafio.Exception.BadRequestException;
import desafio.desafio.Models.Products;
import desafio.desafio.Repository.ProductsRepository;
import desafio.desafio.mapper.ProductsMapper;
import desafio.desafio.requests.ProductsPostRequestBody;
import desafio.desafio.requests.ProductsPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository productsRepository;

    public Page<Products> listAll(Pageable pageable){
        return productsRepository.findAll(pageable);
    }

    public List<Products> findByName(String name){
        return productsRepository.findByName(name);
    }

    public Products findById(Long id){
        return productsRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Commom User not Found"));

    }

    public Products addProducts(ProductsPostRequestBody productsPostRequestBody){
        return productsRepository.save(ProductsMapper.INSTANCE.toPostProduct(productsPostRequestBody));
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
