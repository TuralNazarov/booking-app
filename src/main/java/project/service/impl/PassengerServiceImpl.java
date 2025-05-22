package project.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import project.exception.NotFoundException;
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
    @Qualifier("passengersMapper")
    private final PassengersMapper passengerMapper;

    @Override
    public List<PassengersDto> findAll() {
        return passengersRepository.findAll().stream().map(passengerMapper::toDto).toList();
    }

    @Override
    public PassengersDto findById(long id) {
        return passengerMapper.toDto(passengersRepository.findById(id).orElseThrow(() -> new NotFoundException("Passenger not found")));
    }

    @Override
    public PassengersDto save(PassengersDto passengersDto) {
        System.out.println("Received DTO: " + passengersDto);
        Passengers passenger = passengerMapper.toEntity(passengersDto);
        System.out.println("Mapped Entity: " + passenger);
        return passengerMapper.toDto(passenger);
    }

    @Override
    public void delete(long id) {
        if (!passengersRepository.existsById(id)){
            throw new NotFoundException("Passenger not found with id: " + id);
        }
        passengersRepository.deleteById(id);
    }

    @Override
    public PassengersDto update(PassengersDto passengersDto) {
        Passengers existingPassenger = passengersRepository.findById(passengersDto.getId()).orElseThrow(() -> new RuntimeException("Passenger ID: " + passengersDto.getId() + " not found"));
        passengerMapper.updateEntityFromDto(passengersDto, existingPassenger);
        Passengers updatedPassenger = passengersRepository.save(existingPassenger);
        return passengerMapper.toDto(updatedPassenger);
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

        return matchedPassengers.stream().map(passengerMapper::toDto).collect(Collectors.toList());
    }
}