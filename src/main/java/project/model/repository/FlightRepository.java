package project.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.entity.Flight;
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
