package ru.magenta.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
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




    @PostMapping(value = "/test",produces =  MediaType.APPLICATION_XML_VALUE )
    public String findDistance(@RequestBody CityWrapper cityWrapper) {
        List<Float> list = new ArrayList<>();
        for (int i = 0; i < cityWrapper.getFromCities().size(); i++) {
            list.add(CitiesDistance
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


    @GetMapping("1234")
    public CityWrapper test() {

        CityWrapper cityWrapper = new CityWrapper();

        List<City> from = new ArrayList<>();

        City city = new City();
        city.setName("CityName");

        city.setLongitude(1234F);
        city.setLatitude(123F);
        city.setId(1L);

        from.add(city);


        List<City> to = new ArrayList<>();
        to.add(city);


        cityWrapper.setFromCities(from);
        cityWrapper.setToCities(to);
        cityWrapper.setName("12345");
        return cityWrapper;
    }

    @PostMapping(value = "/get",produces =  MediaType.APPLICATION_XML_VALUE )
    public MatrixWrapper getCity(@RequestBody CityWrapper cityWrapper) {

        MatrixWrapper matrixWrapper = new MatrixWrapper();
        matrixWrapper.initialize(cityWrapper, 2);
        return matrixWrapper;
    }

}
