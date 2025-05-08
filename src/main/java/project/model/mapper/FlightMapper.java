package project.model.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import project.model.dto.FlightDto;
import project.model.entity.FLight;

import java.util.List;

@Mapper (componentModel="spring")
public interface FlightMapper extends EntityMapper<FlightDto, FLight> {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);


    @Override
    FLight toEntity(FlightDto dto);
    @Override
    List<FLight> toEntityList(List<FlightDto> dtoList);
    @Override
    FlightDto toDto(FLight fLight);
    @Override
    List<FlightDto> toDtoList(List<FLight> flightList);


}
