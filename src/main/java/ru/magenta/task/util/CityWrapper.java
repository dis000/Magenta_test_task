package ru.magenta.task.util;

import lombok.Getter;
import lombok.Setter;
import ru.magenta.task.entity.City;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Cities")
public class CityWrapper {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "fromCity")
    private List<City> fromCities;

    @XmlElement(name = "toCity")
    private List<City> toCities;


}
