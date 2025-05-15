package project.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import project.model.dto.BookingDto;
import project.model.dto.PassengersDto;
import project.model.entity.Booking;
import project.model.entity.Flight;
import project.model.entity.Passengers;
import project.model.mapper.BookingMapper;
import project.model.mapper.PassengersMapper;
import project.model.repository.BookingRepository;
import project.model.repository.FlightRepository;
import project.service.BookingService;
import project.service.FlightService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final FlightRepository flightRepository;
    private final PassengerServiceImpl passengerService;
    private final FlightService flightService;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              BookingMapper bookingMapper,
                              FlightRepository flightRepository,
                              PassengerServiceImpl passengerService,
                              FlightService flightService) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
        this.flightRepository = flightRepository;
        this.passengerService = passengerService;
        this.flightService = flightService;
    }

    @Override
    public List<BookingDto> findAll() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream().map(bookingMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public BookingDto findById(long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
        return bookingMapper.toDto(booking);
    }

    @Override
    @Transactional
    public BookingDto save(BookingDto bookingDto) {
        Flight flight = flightRepository.findById(bookingDto.getFlightId()).orElse(null);

        if (flight.getAvailableSeats() < bookingDto.getNumberOfSeats()) {
            throw new IllegalArgumentException("Not enough seats available on this flight");
        }

        PassengersDto passengersDto = passengerService.findById(bookingDto.getPassengerId());

        Passengers passenger = PassengersMapper.INSTANCE.toEntity(passengersDto);
        Booking booking = new Booking();
        booking.setFlight(flight);
        booking.setPassengers(passenger);
        booking.setNumberOfSeats(bookingDto.getNumberOfSeats());

        flightService.updateAvailableSeats(flight.getId(), bookingDto.getNumberOfSeats());

        booking = bookingRepository.save(booking);

        return bookingMapper.toDto(booking);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));

        Flight flight = booking.getFlight();
        int updatedSeats = flight.getAvailableSeats() + booking.getNumberOfSeats();
        flight.setAvailableSeats(updatedSeats);
        flightRepository.save(flight);

        bookingRepository.deleteById(id);
    }
}
