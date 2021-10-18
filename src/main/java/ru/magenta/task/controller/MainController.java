package ru.magenta.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.magenta.task.util.CitiesDistance;
import ru.magenta.task.util.CityWrapper;
import ru.magenta.task.entity.City;
import ru.magenta.task.util.matrix.MatrixMap;
import ru.magenta.task.util.matrix.MatrixRow;
import ru.magenta.task.util.matrix.MatrixWrapper;

import javax.persistence.criteria.From;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    CitiesDistance citiesDistance;



    @PostMapping(value = "/test",produces =  MediaType.APPLICATION_XML_VALUE )
    public String findDistance(@RequestBody CityWrapper cityWrapper) {
        List<Float> list = new ArrayList<>();
        for (int i = 0; i < cityWrapper.getFromCities().size(); i++) {
            list.add(citiesDistance
                    .distFrom(cityWrapper.getFromCities().get(i),cityWrapper.getToCities().get(i)));
        }
        return list.get(0).toString();
      //  return list;
      //  return CitiesDistance.distFrom(fromCity, fromCity);
    }

    @GetMapping(produces = { MediaType.APPLICATION_XML_VALUE  })
    public City convert() {
        City city = new City();
        city.setId(1L);
        city.setLatitude(1234F);
        city.setLongitude(123F);
        city.setName("Moscow");
        return city;
    }

    @Autowired
    MatrixMap matrixMap;

    @GetMapping(value = "/get",produces =  MediaType.APPLICATION_XML_VALUE )
    public MatrixWrapper getCity() {


        City city = new City();

        city.setLongitude(1000F);
        city.setLatitude(1500F);
        city.setName("moscow");

        City city2 = new City();
        city2.setLongitude(1500F);
        city2.setLatitude(1000F);
        city2.setName("Samara");

        List<City> cities = new ArrayList<>();
        cities.add(city);
        cities.add(city2);


        return new MatrixWrapper(matrixMap.create(cities));
    }

}
