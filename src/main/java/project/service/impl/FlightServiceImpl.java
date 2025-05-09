package project.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.exception.ResourceNotFoundException;
import project.model.dto.FlightDto;
import project.model.entity.Flight;
import project.model.mapper.FlightMapper;
import project.model.repository.FlightRepository;
import project.service.FlightService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @Override
    public List<FlightDto> findAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return flights.stream().map(flightMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public FlightDto findFlightById(long id) {
        Flight flight = flightRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Flight not found"));
        return flightMapper.toDto(flight);
    }

    @Override
    public FlightDto addFlight(FlightDto flightDto) {
        Flight newFlight = flightMapper.toEntity(flightDto);
        Flight savedFlight = flightRepository.save(newFlight);
        return flightMapper.toDto(savedFlight);
    }

    @Override
    public FlightDto updateFlight(FlightDto flightDto) {
        Flight existingFlight = flightRepository.findById(flightDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Flight ID: " + flightDto.getId() + " not found"));
        flightMapper.updateEntityFromDto(flightDto, existingFlight);
        Flight updatedFlight = flightRepository.save(existingFlight);
        return flightMapper.toDto(updatedFlight);
    }

    @Override
    public void deleteFlight(long id) {
        if (!flightRepository.existsById(id)) {
            throw new ResourceNotFoundException("Flight ID: " + id + " not found");
        }
        flightRepository.deleteById(id);
    }

    @Override
    public void saveFlight(FlightDto flightDto) {
        Flight flight = flightMapper.toEntity(flightDto);
        flightRepository.save(flight);
    }

    @Override
    @Transactional
    public void updateAvailableSeats(Long flightId, int seatsToBook) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Flight not found with id: " + flightId));

        int currentSeats = flight.getAvailableSeats();
        if (currentSeats < seatsToBook) {
            throw new IllegalArgumentException("Not enough seats available");
        }

        flight.setAvailableSeats(currentSeats - seatsToBook);
        flightRepository.save(flight);
    }

    @Override
    public List<FlightDto> searchFlights(String origin, String destination, int availableSeats) {
        return List.of();
    }

    @Override
    public List<FlightDto> getUpcomingFlights() {
        return List.of();
    }

}
