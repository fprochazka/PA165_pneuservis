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
    OrderDTO create(CreateOrderDTO order);

    void update(UpdateOrderDTO order);

    void delete(OrderDTO order);

    OrderDTO findOrderById(Long orderId);

    List<OrderDTO> findClientOrders(Long clientId);

    List<OrderDTO> findAllOrders();

    OrderBillingDTO getOrderBilling(Long orderId);
}
