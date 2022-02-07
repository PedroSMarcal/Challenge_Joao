package desafio.desafio.mapper;

import desafio.desafio.Models.Products;
import desafio.desafio.requests.ProductsPostRequestBody;
import desafio.desafio.requests.ProductsPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ProductsMapper {
    public static final ProductsMapper INSTANCE = Mappers.getMapper(ProductsMapper.class);
    public abstract Products toPostProduct(ProductsPostRequestBody productsPostRequestBody);
    public abstract Products toProduct(ProductsPutRequestBody productsPutRequestBody);
}
