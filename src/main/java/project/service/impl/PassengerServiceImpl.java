package project.service.impl;

import org.springframework.stereotype.Service;
import project.model.dto.PassengersDto;
import project.model.entity.Passengers;
import project.service.PassengerService;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {
    @Override
    public List<Passengers> findAll() {
        return List.of();
    }

    @Override
    public Passengers findById(long id) {
        return null;
    }

    @Override
    public void save(Passengers passengers) {

    }

    @Override
    public void delete(Passengers passengers) {

    }

    @Override
    public PassengersDto update(Passengers passengers) {
        return null;
    }

    @Override
    public List<Passengers> search(String search, int start, int end) {
        return List.of();
    }
}
