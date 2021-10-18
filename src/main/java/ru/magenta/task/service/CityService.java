package ru.magenta.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.magenta.task.entity.City;
import ru.magenta.task.repository.CityRepository;

import java.util.List;

@Service
public class CityService implements ICityService {

    @Autowired
    CityRepository repository;

    public void saveAll(List<City> citiesList) {
        repository.saveAll(citiesList);
    }
// TODO сделать чтобы при ошибке сохранения города и одним и тем же названием вылетала своя exception
    public void save(City city) {
        repository.save(city);
    }

    public City getById(Long id) {
        return repository.getById(id);
    }

}
