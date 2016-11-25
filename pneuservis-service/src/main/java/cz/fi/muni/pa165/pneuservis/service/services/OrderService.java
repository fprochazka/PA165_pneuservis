package cz.fi.muni.pa165.pneuservis.service.services;

import cz.fi.muni.pa165.pneuservis.entity.Order;
import cz.fi.muni.pa165.pneuservis.service.exception.PneuservisPortalDataAccessException;

import java.util.List;

/**
 * Created by vit.holasek on 23.11.2016.
 */
public interface OrderService {
    Order create(Order order);

    void update(Order order);

    void delete(Order order);

    Order findOrderById(Long orderId);

    List<Order> findClientOrders(Long clientId);

    List<Order> findAllOrders();

    OrderBilling getOrderBilling(Long orderId);
}
