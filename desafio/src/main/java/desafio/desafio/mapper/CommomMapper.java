package desafio.desafio.mapper;


import desafio.desafio.Models.Commom;
import desafio.desafio.requests.CommomPostRequestBody;
import desafio.desafio.requests.CommomPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CommomMapper {
    public static final CommomMapper INSTANCE = Mappers.getMapper(CommomMapper.class);
    public abstract Commom toACommom(CommomPostRequestBody commomPostRequestBody);
    public abstract Commom toACommom(CommomPutRequestBody commomPutRequestBody);
}
