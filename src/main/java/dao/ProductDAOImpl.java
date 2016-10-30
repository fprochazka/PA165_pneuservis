/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Product;
import java.math.BigDecimal;
import java.util.List;
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
            throw new IllegalArgumentException("Product is null!");
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
            throw new IllegalArgumentException("Product is null!");
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

    @Override
    public List<Product> findAll() {
        return em.createQuery("SELECT product FROM Product product", Product.class)
                .getResultList();
    }

    @Override
    public List<Product> findByPrice(BigDecimal price) {
        return em.createQuery("SELECT product FROM Product product WHERE product.price = :price",
                Product.class).setParameter("price", price).getResultList();
    }

    @Override
    public List<Product> findByDescription(String description) {
        return em.createQuery("SELECT product FROM Product product WHERE product.description LIKE :description",
                Product.class).setParameter("description", "%" + description + "%").getResultList();
    }

    @Override
    public List<Product> findByVehicleType(String typeOfVehicle) {
        return em.createQuery("SELECT product FROM Product product WHERE product.typeOfVehicle LIKE :typeOfVehicle",
                Product.class).setParameter("typeOfVehicle", "%" + typeOfVehicle + "%").getResultList();
    }

}
