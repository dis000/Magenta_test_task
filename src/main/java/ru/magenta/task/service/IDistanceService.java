package ru.magenta.task.service;

import ru.magenta.task.entity.Distance;

import java.util.List;

public interface IDistanceService {
    void save(Distance distance);
    void saveAll(List<Distance> distanceList);
    Distance getById(Long id);
}
