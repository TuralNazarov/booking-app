package project.service.impl;

import org.springframework.stereotype.Service;
import project.model.dto.BookingDto;
import project.service.BookingService;

import java.util.List;

@Service
public class BookingSericeImpl implements BookingService {


    @Override
    public List<BookingDto> findAll() {
        return List.of();
    }

    @Override
    public BookingDto findById(long id) {
        return null;
    }

    @Override
    public BookingDto save(BookingDto bookingDto) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }
}
