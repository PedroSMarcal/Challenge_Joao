package desafio.desafio.mapper;


import desafio.desafio.Models.CarShop;
import desafio.desafio.requests.CarShopPostRequestBody;
import desafio.desafio.requests.CarShopPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CarShopMapper {
    public static final CarShopMapper INSTANCE = Mappers.getMapper(CarShopMapper.class);
    public abstract CarShop toCarPostShop(CarShopPostRequestBody commomPostRequestBody);
    public abstract CarShop toCarShop(CarShopPutRequestBody carShopPutRequestBody);
}
