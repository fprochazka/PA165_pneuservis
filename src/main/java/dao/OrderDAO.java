/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Order;
import java.util.List;

/**
 *
 * @author Jaroslav Bonco
 */
public interface OrderDAO {
    
    public void create (Order order) throws IllegalArgumentException;
    
    public void update (Order order);
    
    public void delete (Order order);
    
    public Order findById (long id);
    
    public Order findByClientId (long clientId);
    
    public List<Order> findAll ();
}
