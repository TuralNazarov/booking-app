package project.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import project.model.dto.PassangersDto;
import project.model.entity.Pasangers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PassangerMapper extends EntityMapper<PassangersDto, Pasangers> {
    PassangerMapper INSTANCE = Mappers.getMapper(PassangerMapper.class);

    @Override
    Pasangers toEntity(PassangersDto dto);

    @Override
    List<Pasangers> toEntityList(List<PassangersDto> dtoList);

    @Override
    PassangersDto toDto(Pasangers entity);

    @Override
    List<PassangersDto> toDtoList(List<Pasangers> entityList);
}
