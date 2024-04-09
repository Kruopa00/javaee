package org.example.lab01.entities;

import javax.persistence.*;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode
@Getter @Setter
@NamedQueries(
        @NamedQuery(name = "Grupe.findAll", query = "select   g from Grupe as g")
)
public class Grupe {
    @Id
    @GeneratedValue
    private Integer id;

    @Basic(optional = false)
    private String specialybe;

    @Basic(optional = false)
    private Integer kursas;

    @Basic(optional = false)
    private Integer grupe;

    @OneToMany(mappedBy = "grupe")
    private List<Studentas> studentai;
}
