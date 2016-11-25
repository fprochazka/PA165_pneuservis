package cz.fi.muni.pa165.pneuservis.service.services;

import cz.fi.muni.pa165.pneuservis.entity.Order;
import cz.fi.muni.pa165.pneuservis.service.exception.PneuservisPortalDataAccessException;

import java.util.List;

/**
 * Created by vit.holasek on 23.11.2016.
 */
public interface OrderService {
    Order create(Order order) throws PneuservisPortalDataAccessException;

    void update(Order order) throws PneuservisPortalDataAccessException;

    void delete(Order order) throws PneuservisPortalDataAccessException;

    Order findOrderById(Long orderId) throws PneuservisPortalDataAccessException;

    List<Order> findClientOrders(Long clientId) throws PneuservisPortalDataAccessException;

    List<Order> findAllOrders() throws PneuservisPortalDataAccessException;

    OrderBilling getOrderBilling(Long orderId) throws PneuservisPortalDataAccessException;
}
