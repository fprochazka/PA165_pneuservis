/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.pneuservis.dao;

import cz.fi.muni.pa165.pneuservis.entity.Product;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Matej Šípka
 */
public interface ProductDAO {

    /**
     * Mothod used to create a new product.
     *
     * @param product the product
     * @throws IllegalArgumentException
     */
    void create(Product product) throws IllegalArgumentException;

    /**
     * Method used to update the product.
     *
     * @param product
     * @throws IllegalArgumentException
     */
    void update(Product product) throws IllegalArgumentException;

    /**
     * Method used to delete the product.
     *
     * @param product
     * @throws IllegalArgumentException
     */
    void delete(Product product) throws IllegalArgumentException;

    /**
     * Finds the product according to it's id.
     *
     * @param id the product ID
     * @return found product, null if not found
     */
    Product findById(long id);

    /**
     * Finds products according to a price.
     *
     * @param price the products price.
     * @return List of product found
     */
    List<Product> findByPrice(BigDecimal price);

    /**
     * Finds products according to a description.
     *
     * @param description the products description.
     * @return List of product found
     */
    public List<Product> findByDescription(String description);

    /**
     * Finds products according to a assigned vehicle type.
     *
     * @param typeOfVehicle the products type of vehicle.
     * @return List of product found
     */
    public List<Product> findByVehicleType(String typeOfVehicle);

    /**
     * Finds all products stored in the DB.
     * @return list of found products
     */
    List<Product> findAll();
}
