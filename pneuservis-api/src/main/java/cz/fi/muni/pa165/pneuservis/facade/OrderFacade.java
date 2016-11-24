package cz.fi.muni.pa165.pneuservis.facade;

import cz.fi.muni.pa165.pneuservis.dto.CreateUpdateOrderDTO;
import cz.fi.muni.pa165.pneuservis.dto.OrderBillingDTO;
import cz.fi.muni.pa165.pneuservis.dto.OrderDTO;

import java.util.List;

/**
 * Created by vit.holasek on 23.11.2016.
 */
public interface OrderFacade {
    OrderDTO create(CreateUpdateOrderDTO order) throws IllegalArgumentException;

    void update(CreateUpdateOrderDTO order) throws IllegalArgumentException;

    void delete(Long orderId);

    OrderDTO findOrderById(Long orderId);

    List<OrderDTO> findUserOrders(Long userId);

    List<OrderDTO> findAllOrders();

    OrderBillingDTO getOrderBilling(Long orderId);
}
