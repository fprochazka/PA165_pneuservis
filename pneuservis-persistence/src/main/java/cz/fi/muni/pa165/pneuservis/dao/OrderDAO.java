/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.pneuservis.dao;

import cz.fi.muni.pa165.pneuservis.entity.Order;
import java.util.List;

/**
 *
 * @author Jaroslav Bonco
 */
public interface OrderDAO {

    /**
     * Creates a new order in the DB.
     *
     * @param order The order to be stored
     * @throws IllegalArgumentException if some arguments are not set
     */
    public void create(Order order) throws IllegalArgumentException;

    /**
     * Updates the order in the DB.
     *
     * @param order The order to be updated
     * @throws IllegalArgumentException if some arguments are not set
     */
    public void update(Order order);

    /**
     * Deletes the order from the DB.
     *
     * @param order The order to be deleted
     */
    public void delete(Order order);

    /**
     * Finds a order by its unique ID
     *
     * @param id The orders ID
     * @return Found order, null if not found
     */
    public Order findById(long id);

    /**
     * Finds all order by its client ID
     *
     * @param clientId the ID of a client assignet to the order
     * @return list of found orders
     */
    public List<Order> findByClientId(long clientId);

    /**
     * Finds all orders stored in the DB
     *
     * @return List of the found orders
     */
    public List<Order> findAll();
}
