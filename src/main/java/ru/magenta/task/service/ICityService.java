package ru.magenta.task.service;

import ru.magenta.task.entity.City;

import java.util.List;

public interface ICityService {
    void save(City city);
    void saveAll(List<City> citiesList);
    City getById(Long id);
}
