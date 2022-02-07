package desafio.desafio.mapper;

import desafio.desafio.Models.Provider;
import desafio.desafio.requests.ProviderPostRequestBody;
import desafio.desafio.requests.ProviderPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ProviderMapper {
    public static final ProviderMapper INSTANCE = Mappers.getMapper(ProviderMapper.class);
    public abstract Provider toPostProvider(ProviderPostRequestBody providerPostRequestBody);

    public abstract Provider toAProvider(ProviderPutRequestBody providerPutRequestBody);
}
