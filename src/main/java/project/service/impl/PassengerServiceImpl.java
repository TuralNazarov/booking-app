package project.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.model.dto.PassengersDto;
import project.model.entity.Passengers;
import project.model.mapper.PassengersMapper;
import project.model.repository.PassengersRepository;
import project.service.PassengerService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PassengerServiceImpl implements PassengerService {

    private final PassengersRepository passengersRepository;
    private final PassengersMapper passengersMapper;

    @Override
    public List<PassengersDto> findAll() {
        return passengersRepository.findAll().stream().map(passengersMapper::toDto).toList();
    }

    @Override
    public PassengersDto findById(long id) {
        return passengersMapper.toDto(passengersRepository.findById(id).orElseThrow(() -> new RuntimeException("Passenger not found")));
    }

    @Override
    public void save(PassengersDto passengersDto) {
        Passengers passenger = passengersMapper.toEntity(passengersDto);
        passengersRepository.save(passenger);
    }

    @Override
    public void delete(long id) {
        if (!passengersRepository.existsById(id)){
            throw new RuntimeException("Passenger not found with id: " + id);
        }
        passengersRepository.deleteById(id);
    }

    @Override
    public PassengersDto update(PassengersDto passengersDto) {
        Passengers existingPassenger = passengersRepository.findById(passengersDto.getId()).orElseThrow(() -> new RuntimeException("Passenger ID: " + passengersDto.getId() + " not found"));
        passengersMapper.updateEntityFromDto(passengersDto, existingPassenger);
        Passengers updatedPassenger = passengersRepository.save(existingPassenger);
        return passengersMapper.toDto(updatedPassenger);
    }

    @Override
    public List<PassengersDto> search(String firstName, String lastName, long id) {
        List<Passengers> matchedPassengers;

        if (id > 0) {
            Optional<Passengers> optionalPassenger = passengersRepository.findById(id);
            matchedPassengers = optionalPassenger.map(List::of).orElse(List.of());
        } else {
            matchedPassengers = passengersRepository
                    .findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(
                            firstName != null ? firstName : "",
                            lastName != null ? lastName : ""
                    );
        }

        return matchedPassengers.stream().map(passengersMapper::toDto).collect(Collectors.toList());
    }
}