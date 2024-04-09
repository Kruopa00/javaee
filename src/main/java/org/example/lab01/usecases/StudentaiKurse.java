package org.example.lab01.usecases;

import lombok.Getter;
import lombok.Setter;
import org.example.lab01.entities.Grupe;
import org.example.lab01.entities.Studentas;
import org.example.lab01.presistence.GrupesDAO;
import org.example.lab01.presistence.StudentaiDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Model
public class StudentaiKurse implements Serializable {

    @Inject
    private GrupesDAO grupesDAO;

    @Inject
    private StudentaiDAO studentaiDAO;

    @Getter @Setter
    private Grupe grupe;

    @Getter @Setter
    private Studentas naujasStudentas = new Studentas();

    @PostConstruct
    public void init() {
        Map<String, String> requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer grupeId = Integer.parseInt(requestParams.get("grupeId"));
        this.grupe = grupesDAO.findOne(grupeId);
    }

    @Transactional
    public void createStudentas() {
        naujasStudentas.setGrupe(this.grupe);
        studentaiDAO.persist(naujasStudentas);
    }
}