package project.model.mapper;


import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import project.model.dto.FlightDto;
import project.model.entity.Flight;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightMapper extends EntityMapper<FlightDto, Flight> {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);


    @Override
    Flight toEntity(FlightDto dto);

    @Override
    List<Flight> toEntityList(List<FlightDto> dtoList);

    @Override
    FlightDto toDto(Flight fLight);

    @Override
    List<FlightDto> toDtoList(List<Flight> flightList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(FlightDto dto, @MappingTarget Flight entity);
}
