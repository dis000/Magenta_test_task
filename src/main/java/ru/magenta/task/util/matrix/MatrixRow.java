package ru.magenta.task.util.matrix;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement()
public class MatrixRow {



    @XmlElement(name = "row")
    private List<Float> row;

    public MatrixRow(List<Float> row) {
        this.row = row;
    }

    public MatrixRow() {
    }
}