package project.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.entity.Passangers;

@Repository
public interface PasangersRepository extends JpaRepository<Passangers, Long> {
}
