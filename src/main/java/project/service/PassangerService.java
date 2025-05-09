package project.service;

import project.model.dto.PassangersDto;
import project.model.entity.Passangers;

import java.util.List;

public interface PassangerService {

    public List<Passangers> findAll();

    public Passangers findById(int id);

    public void save(Passangers passangers);

    public void delete(Passangers passangers);

    public PassangersDto update(Passangers passangers);

    public List<Passangers> search(String search, int start, int end);
}
