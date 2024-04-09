package org.example.lab01.usecases;

import lombok.Getter;
import lombok.Setter;
import org.example.lab01.entities.Studentas;
import org.example.lab01.presistence.StudentaiDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdateStudentas implements Serializable {
    private Studentas studentas;

    @Inject
    private StudentaiDAO studentaiDAO;

    @PostConstruct
    private void init() {
        Map<String, String> requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer studentasId = Integer.parseInt(requestParams.get("studentasId"));
        this.studentas = studentaiDAO.findOne(studentasId);
    }

    @Transactional
    public String updateStudentasInformation() {
        try {
            studentaiDAO.update(this.studentas);
        } catch (OptimisticLockException e) {
            return "/studentasDetails.xhtml?faces-redirect=true&studentasId=" + this.studentas.getId() + "&error=optimistic-lock-exception";
        }
        return "/studentai.xhtml?grupeId=" + this.studentas.getGrupe().getId() + "&faces-redirect=true";
    }
}
