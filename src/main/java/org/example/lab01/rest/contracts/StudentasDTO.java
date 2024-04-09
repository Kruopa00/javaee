package org.example.lab01.rest.contracts;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StudentasDTO {
    private Integer number;
    private String vardas;
    private String pavarde;
    private String specialybe;
    private Integer kursas;
    private Integer grupe;
}
