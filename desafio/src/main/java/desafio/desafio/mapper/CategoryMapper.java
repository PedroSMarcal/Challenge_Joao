package desafio.desafio.mapper;

import desafio.desafio.Models.Category;
import desafio.desafio.requests.CategoryPostRequestBody;
import desafio.desafio.requests.CategoryPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CategoryMapper {
    public static final CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    public abstract Category toPostCategory(CategoryPostRequestBody providerPostRequestBody);
    public abstract Category toCategory(CategoryPutRequestBody providerPutRequestBody);
}
