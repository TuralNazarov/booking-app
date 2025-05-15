package project.service;

import project.model.dto.PassengersDto;
import project.model.entity.Passengers;

import java.util.List;

public interface PassengerService {

    public List<Passengers> findAll();

    public Passengers findById(long id);

    public void save(Passengers passengers);

    public void delete(Passengers passengers);

    public PassengersDto update(Passengers passengers);

    public List<Passengers> search(String search, int start, int end);
}
