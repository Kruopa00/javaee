package org.example.lab01.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@NamedQueries(
        @NamedQuery(name = "Studentas.findAll", query = "select   s from Studentas as s")
)
@EqualsAndHashCode
public class Studentas {
    @Id
    @GeneratedValue
    private Integer id;

    @Basic(optional = false)
    private Integer number;

    @Basic(optional = false)
    private String vardas;

    @Basic(optional = false)
    private String pavarde;

    @ManyToOne
    private Grupe grupe;

    @ManyToMany
    private List<PasirenkamasKursas> pasirenkamiKursai;

}
