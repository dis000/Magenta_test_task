package ru.magenta.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.magenta.task.entity.Distance;
import ru.magenta.task.repository.DistanceRepository;

import java.util.List;

@Service
public class DistanceService implements IDistanceService {
    @Autowired
    DistanceRepository repository;

    public void saveAll(List<Distance> distanceList) {
        repository.saveAll(distanceList);
    }

    public void save(Distance distance) {
        repository.save(distance);
    }

    public Distance getById(Long id) {
        return repository.getById(id);
    }

}
