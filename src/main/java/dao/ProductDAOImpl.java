/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Product;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Matej Šípka
 */
@Repository
public class ProductDAOImpl implements ProductDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Product product) throws IllegalArgumentException {

        if (product == null) {
            throw new IllegalArgumentException("Tire is null null!");
        }

        if (product.getPrice() == null || product.getTypeOfVehicle() == null) {
            throw new IllegalArgumentException("Product price or vehicle type can not be null!");
        } else {
            em.persist(product);
        }
    }

    @Override
    public void update(Product product) throws IllegalArgumentException {

        if (product == null) {
            throw new IllegalArgumentException("product is null!");
        }

        if (product.getPrice() == null || product.getTypeOfVehicle() == null) {
            throw new IllegalArgumentException("Product price or vehicle type can not be null!");
        } else {
            em.merge(product);
        }
    }

    @Override
    public void delete(Product product) throws IllegalArgumentException {
        if (product == null) {
            throw new IllegalArgumentException("product is null!");
        }
        em.remove(product);
    }

    @Override
    public Product findById(long id) {
        return em.find(Product.class, id);
    }

}
