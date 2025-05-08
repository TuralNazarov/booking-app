package project.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import project.model.dto.BookingDto;
import project.model.entity.Booking;


import java.util.List;

@Mapper (componentModel = "spring")
public interface BookingMapper extends EntityMapper <BookingDto, Booking> {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    @Override
    Booking toEntity(BookingDto dto);
    @Override
    List<Booking> toEntityList(List<BookingDto> dtoList);
    @Override
    BookingDto toDto(Booking booking);
    @Override
    List<BookingDto> toDtoList(List<Booking> bookingList);
}
