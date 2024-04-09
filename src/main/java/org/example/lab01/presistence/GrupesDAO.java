package org.example.lab01.presistence;

import org.example.lab01.entities.Grupe;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class GrupesDAO {
    @Inject
    private EntityManager em;

    public List<Grupe> loadAll() {
        return em.createNamedQuery("Grupe.findAll", Grupe.class).getResultList();
    }

    public void persist(Grupe grupe) {
        this.em.persist(grupe);
    }

    public Grupe findOne(Integer id) {
        return em.find(Grupe.class, id);
    }

    public Grupe update(Grupe grupe) {
        return em.merge(grupe);
    }

    public void delete(Integer id) {
        Grupe grupe = findOne(id);
        if (grupe != null) {
            em.remove(grupe);
        }
    }
}
