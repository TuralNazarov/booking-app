package project.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import project.model.dto.PassangersDto;
import project.model.entity.Passangers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PassangerMapper extends EntityMapper<PassangersDto, Passangers> {
    PassangerMapper INSTANCE = Mappers.getMapper(PassangerMapper.class);

    @Override
    Passangers toEntity(PassangersDto dto);

    @Override
    List<Passangers> toEntityList(List<PassangersDto> dtoList);

    @Override
    PassangersDto toDto(Passangers entity);

    @Override
    List<PassangersDto> toDtoList(List<Passangers> entityList);
}
