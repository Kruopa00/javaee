package org.example.lab01.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
public class PasirenkamasKursas {
    @Id
    @GeneratedValue
    private Integer id;

    @Basic(optional = false)
    private String pavadinimas;

    @ManyToMany(mappedBy = "pasirenkamiKursai")
    private List<Studentas> studentai;
}
