package project.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.entity.Flight;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByOriginIgnoreCaseAndDestinationIgnoreCaseAndAvailableSeatsGreaterThanEqual(String origin, String destination, int availableSeats);


    List<Flight> findByTimestampAfter(LocalDateTime timestamp);


}
