package project.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.model.repository.FlightRepository;

@Service
@AllArgsConstructor
public class FlightServiceImpl {
    private FlightRepository flightRepository;

}
