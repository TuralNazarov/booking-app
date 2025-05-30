package project.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
