package project.service;


import project.model.dto.FlightDto;

import java.util.List;

public interface FlightService {

    public List<FlightDto> findAllFlights();
    public FlightDto findFlightById(long id);
    public FlightDto addFlight(FlightDto flight);
    public FlightDto updateFlight(FlightDto flight);
    public void deleteFlight(long id);
    public List<FlightDto> searchFlights(String search, int start, int end);
    public List<FlightDto> getUpcomingFlights();
}
