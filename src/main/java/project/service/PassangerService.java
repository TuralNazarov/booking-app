package project.service;

import project.model.dto.PassangersDto;
import project.model.entity.Pasangers;

import java.util.List;

public interface PassangerService {

    public List<Pasangers> findAll();

    public Pasangers findById(int id);

    public void save(Pasangers pasangers);

    public void delete(Pasangers pasangers);

    public PassangersDto update(Pasangers pasangers);

    public List<Pasangers> search(String search, int start, int end);
}
