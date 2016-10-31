/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Tire;
import enums.TireManufacturer;
import enums.TireType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Matej Sipka
 */
public class TireDAOImpl implements TireDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Tire tire) throws IllegalArgumentException {

        if (tire == null) {
            throw new IllegalArgumentException("Tire is null null!");
        }

        if (tire.getManufacturer() == null || tire.getType() == null) {
            throw new IllegalArgumentException("Tire manufacturer or type can not be null!");
        } else if (tire.getDiameter() <= 0) {
            throw new IllegalArgumentException("Diameter must be a positive number.");
        } else {
            em.persist(tire);
        }
    }

    @Override
    public void update(Tire tire) {

        if (tire == null) {
            throw new IllegalArgumentException("Tire is null null!");
        }

        if (tire.getManufacturer() == null || tire.getType() == null) {
            throw new IllegalArgumentException("Tire manufacturer or type can not be null!");
        } else if (tire.getDiameter() <= 0) {
            throw new IllegalArgumentException("Diameter must be a positive number.");
        } else {
            em.merge(tire);
        }
    }

    @Override
    public void delete(Tire tire) {
        if (tire == null) {
            throw new IllegalArgumentException("Tire is null null!");
        }
        em.remove(tire);
    }

    @Override
    public Tire findById(long id) {
        return em.find(Tire.class, id);
    }

    @Override
    public List<Tire> findBySize(int size) {
        return em.createQuery("SELECT tire FROM Tire tire WHERE tire.tireSize = :size",
                Tire.class).setParameter("size", size).getResultList();
    }

    @Override
    public List<Tire> findAll() {
        return em.createQuery("SELECT tire FROM Tire tire", Tire.class)
                .getResultList();
    }

    @Override
    public List<Tire> findByManufacturer(TireManufacturer manufacturer) {
//        String manufacturerName = manufacturer.name();
        return em.createQuery("SELECT tire FROM Tire tire WHERE tire.manufacturer = :name",
                Tire.class).setParameter("name", manufacturer).getResultList();
    }

    @Override
    public List<Tire> findByType(TireType type) {
        return em.createQuery("SELECT tire FROM Tire tire WHERE tire.manufacturer = :type",
                Tire.class).setParameter("type", type).getResultList();
    }

    @Override
    public List<Tire> findByCatalogNumber(int catalogNumber) {
        return em.createQuery("SELECT tire FROM Tire tire WHERE tire.catalogNumber = :catalogNumber",
                Tire.class).setParameter("catalogNumber", catalogNumber).getResultList();
    }

    @Override
    public List<Tire> findByDiameter(int diameter) {
        return em.createQuery("SELECT tire FROM Tire tire WHERE tire.diameter = :diameter",
                Tire.class).setParameter("diameter", diameter).getResultList();
    }

    @Override
    public List<Tire> findByProfile(int profile) {
        return em.createQuery("SELECT tire FROM Tire tire WHERE tire.profile = :profile",
                Tire.class).setParameter("diameter", profile).getResultList();
    }

}
