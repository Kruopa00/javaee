package org.example.lab01.presistence;

import org.example.lab01.entities.Studentas;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class StudentaiDAO {
    @Inject
    private EntityManager em;

    public List<Studentas> loadAll() {
        return em.createNamedQuery("Studentas.findAll", Studentas.class).getResultList();
    }

    public void persist(Studentas studentas) {
        this.em.persist(studentas);
    }

    public Studentas findOne(Integer id) {
        return em.find(Studentas.class, id);
    }

    public Studentas update(Studentas studentas) {
        return em.merge(studentas);
    }

    public void delete(Integer id) {
        Studentas studentas = findOne(id);
        if (studentas != null) {
            em.remove(studentas);
        }
    }
}
