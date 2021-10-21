package ru.magenta.task.util.matrix;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.magenta.task.entity.City;
import ru.magenta.task.util.CitiesDistance;
import ru.magenta.task.util.CityWrapper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "MatrixWrapper")
@Component
public class MatrixWrapper {

    @XmlElement
    private List<Float> crowFlight;

    @NonNull
    @XmlElement(name = "Matrix")
    private Map<String, MatrixRow> matrix;


//TODO придумать что-то с enum вместо этой хрени
    public void initialize(CityWrapper cityWrapper, Integer test) {



        switch (test) {
            case 0: this.crowFlight = createCrowFlight(cityWrapper);
            case 1: this.matrix = createMatrix(cityWrapper);
            case 2: {
                this.crowFlight = createCrowFlight(cityWrapper);
                this.matrix = createMatrix(cityWrapper);
            }
        }
    }


    private List<Float> createCrowFlight(CityWrapper cityWrapper) {
        return CitiesDistance.distFrom(cityWrapper.getFromCities(), cityWrapper.getToCities());
    }



    private Map<String, MatrixRow> createMatrix(CityWrapper cityWrapper) {
        List<City> cities = new ArrayList<>();
        cities.addAll(cityWrapper.getFromCities());
        cities.addAll(cityWrapper.getToCities());
        MatrixMap matrixMap = new MatrixMap();
        return matrixMap.create(cities);
    }
}
