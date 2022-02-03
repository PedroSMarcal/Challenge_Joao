package desafio.desafio.mapper;

import desafio.desafio.Models.Admin;
import desafio.desafio.requests.AdminPostRequestBody;
import desafio.desafio.requests.AdminPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public abstract class AdminMapper {
    public static final AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    public abstract Admin toAdminPost(AdminPostRequestBody adminPostRequestBody);

    public abstract Admin toAdmin(AdminPutRequestBody adminPutRequestBody);
}
