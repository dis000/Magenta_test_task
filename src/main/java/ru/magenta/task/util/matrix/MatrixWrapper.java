package ru.magenta.task.util.matrix;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "MatrixWrapper")
@NoArgsConstructor
public class MatrixWrapper {

    @XmlElement
    private List<Float> CrowFlight;

    @NonNull
    @XmlElement(name = "Matrix")
    private Map<String, MatrixRow> matrix;

    public MatrixWrapper(Map<String, MatrixRow> matrix) {
        this.matrix = matrix;
    }
}
