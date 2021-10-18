package ru.magenta.task.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Getter
@Setter
@Entity
@Table
@XmlRootElement(name = "City")
@XmlType(propOrder = {"name", "latitude", "longitude"})
@XmlAccessorType(XmlAccessType.FIELD)
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlTransient
    private Long id;

    @NotNull
    @Column(unique = true)
    @XmlElement(name = "name")
    private String name;

    @NotNull
    @XmlElement(name = "latitude")
    private Float latitude;

    @NotNull
    @XmlElement(name = "longitude")
    private Float longitude;

}
