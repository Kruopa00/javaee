package org.example.lab01.presistence;

import org.example.lab01.entities.PasirenkamasKursas;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class PasirenkamaiKursaiDAO {
    @Inject
    private EntityManager em;

    public void persist(PasirenkamasKursas pasirenkamasKursas) {
        this.em.persist(pasirenkamasKursas);
    }

    public PasirenkamasKursas findOne(Integer id) {
        return em.find(PasirenkamasKursas.class, id);
    }

    public PasirenkamasKursas update(PasirenkamasKursas pasirenkamasKursas) {
        return em.merge(pasirenkamasKursas);
    }

    public void delete(Integer id) {
        PasirenkamasKursas pasirenkamasKursas = findOne(id);
        if (pasirenkamasKursas != null) {
            em.remove(pasirenkamasKursas);
        }
    }
}
