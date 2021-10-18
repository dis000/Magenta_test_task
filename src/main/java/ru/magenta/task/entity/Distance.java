package ru.magenta.task.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@Getter
@Setter
@Entity
@Table
@XmlRootElement(name = "Distance")
@XmlType(propOrder = {"fromCity", "toCity", "distance"})
public class Distance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlTransient
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @XmlElement(name = "fromCity")
    private City fromCity;

    @ManyToOne(fetch = FetchType.LAZY)
    @XmlElement(name = "toCity")
    private City toCity;

    @XmlElement(name = "distance")
    private Double distance;

}
