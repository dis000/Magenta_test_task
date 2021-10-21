package ru.magenta.task.util.matrix;

import org.springframework.stereotype.Component;
import ru.magenta.task.entity.City;
import ru.magenta.task.util.CitiesDistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MatrixMap {



    public Map<String, MatrixRow> create(List<City> cities) {
        Map<String, MatrixRow> matrixRowMap = new HashMap<>();
        for (City city:
             cities) {
             matrixRowMap.put(city.getName(), createMatrixRow(city, cities));
        }
        return matrixRowMap;
    }

    private MatrixRow createMatrixRow(City fromCity, List<City> cities) {
            List<Float> row = new ArrayList<>();
            for (City toCity:
                    cities) {
                row.add(CitiesDistance.distFrom(fromCity, toCity));
            }
        return new MatrixRow(row);
    }

}
