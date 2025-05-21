package project.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import project.model.dto.PassengersDto;
import project.model.entity.Passengers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PassengersMapper extends EntityMapper<PassengersDto, Passengers> {
    PassengersMapper INSTANCE = Mappers.getMapper(PassengersMapper.class);

    @Override
    Passengers toEntity(PassengersDto dto);

    @Override
    List<Passengers> toEntityList(List<PassengersDto> dtoList);

    @Override
    PassengersDto toDto(Passengers entity);

    @Override
    List<PassengersDto> toDtoList(List<Passengers> entityList);

    void updateEntityFromDto(PassengersDto passengersDto, @MappingTarget Passengers existingPassenger);
}
