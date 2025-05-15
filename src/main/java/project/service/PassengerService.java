package project.service;

import project.model.dto.PassengersDto;

import java.util.List;

public interface PassengerService {

    public List<PassengersDto> findAll();

    public PassengersDto findById(long id);

    public void save(PassengersDto passengersDto);

    public void delete(long id);

    public PassengersDto update(PassengersDto passengersDto);

    public List<PassengersDto> search(String firstName, String lastName, long id);
}