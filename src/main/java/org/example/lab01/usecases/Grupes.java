package org.example.lab01.usecases;

import lombok.Getter;
import lombok.Setter;
import org.example.lab01.entities.Grupe;
import org.example.lab01.presistence.GrupesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Grupes {
    @Inject
    private GrupesDAO grupesDAO;

    @Getter @Setter
    private Grupe grupeToCreate = new Grupe();

    @Getter
    private List<Grupe> allGrupes;

    @PostConstruct
    public void init() {
        this.allGrupes = grupesDAO.loadAll();
    }

    @Transactional
    public void createGrupe() {
        this.grupesDAO.persist(grupeToCreate);
    }
}
