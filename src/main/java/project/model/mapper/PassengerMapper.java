package project.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import project.model.dto.PassengersDto;
import project.model.entity.Passengers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PassengerMapper extends EntityMapper<PassengersDto, Passengers> {
    PassengerMapper INSTANCE = Mappers.getMapper(PassengerMapper.class);

    @Override
    Passengers toEntity(PassengersDto dto);

    @Override
    List<Passengers> toEntityList(List<PassengersDto> dtoList);

    @Override
    PassengersDto toDto(Passengers entity);

    @Override
    List<PassengersDto> toDtoList(List<Passengers> entityList);
}
