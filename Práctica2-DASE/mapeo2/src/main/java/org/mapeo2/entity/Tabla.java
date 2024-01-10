package org.mapeo2.entity;

import javax.persistence.*;

@Entity
@Table(name = "mapeo2", schema = "test")
public class Tabla {
    @Id //indicar que la propiedad es una llave
    @Column(name = "id") //descripcion de la columna
    @GeneratedValue(strategy = GenerationType.IDENTITY) //estrategia de manejo de llave
    private Integer id;

    @Column(name = "value", length = 50, columnDefinition = "varchar(50)", nullable = false)
    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Tabla{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}