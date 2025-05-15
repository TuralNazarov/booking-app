package project.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.entity.Passengers;

import java.util.List;

@Repository
public interface PassengersRepository extends JpaRepository<Passengers, Long> {
    List<Passengers> findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(String firstName, String lastName);

}