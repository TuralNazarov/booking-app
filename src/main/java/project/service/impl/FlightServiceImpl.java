package project.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.model.dto.FlightDto;
import project.model.entity.FLight;
import project.model.mapper.FlightMapper;
import project.model.repository.FlightRepository;
import project.service.FlightService;

import java.util.List;
import java.util.stream.Collector;

@Service
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
//    private final FlightMapper flightMapper;

    @Override
    public List<FlightDto> findAllFlights() {
        List<FLight> flights = flightRepository.findAll();
        return List.of();
    }

    @Override
    public FlightDto findFlightById(long id) {
        return null;
    }

    @Override
    public FlightDto addFlight(FlightDto flight) {
        return null;
    }

    @Override
    public FlightDto updateFlight(FlightDto flight) {
        return null;
    }

    @Override
    public void deleteFlight(long id) {

    }

    @Override
    public List<FlightDto> searchFlights(String search, int start, int end) {
        return List.of();
    }

    @Override
    public List<FlightDto> getUpcomingFlights() {
        return List.of();
    }

}
