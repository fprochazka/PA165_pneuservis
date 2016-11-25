package cz.fi.muni.pa165.pneuservis.facade;

import cz.fi.muni.pa165.pneuservis.dto.CreateOrderDTO;
import cz.fi.muni.pa165.pneuservis.dto.OrderBillingDTO;
import cz.fi.muni.pa165.pneuservis.dto.OrderDTO;
import cz.fi.muni.pa165.pneuservis.dto.UpdateOrderDTO;

import java.util.List;

/**
 * Created by vit.holasek on 23.11.2016.
 */
public interface OrderFacade {

    /**
     * Create new order.
     * @param order Order to create
     * @return Order with generated ID
     */
    OrderDTO create(CreateOrderDTO order);

    /**
     * Update order data.
     * @param order Order to update
     */
    void update(UpdateOrderDTO order);

    /**
     * Delete order.
     * @param order
     */
    void delete(OrderDTO order);

    /**
     * Find order with given ID.
     * @param orderId Order ID
     * @return Order
     */
    OrderDTO findOrderById(Long orderId);

    /**
     * Find orders that belongs to the client with given ID
     * @param clientId Client ID
     * @return List of orders
     */
    List<OrderDTO> findClientOrders(Long clientId);

    /**
     * Find all orders
     * @return List of orders
     */
    List<OrderDTO> findAllOrders();

    /**
     * Generate billing information of the order with given ID
     * @param orderId Order ID
     * @return Billing information
     */
    OrderBillingDTO getOrderBilling(Long orderId);
}
