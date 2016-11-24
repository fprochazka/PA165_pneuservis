package cz.fi.muni.pa165.pneuservis.service.facade;

import cz.fi.muni.pa165.pneuservis.dto.CreateOrderDTO;
import cz.fi.muni.pa165.pneuservis.dto.OrderBillingDTO;
import cz.fi.muni.pa165.pneuservis.dto.OrderDTO;
import cz.fi.muni.pa165.pneuservis.dto.UpdateOrderDTO;
import cz.fi.muni.pa165.pneuservis.facade.OrderFacade;

import java.util.List;

/**
 * Created by vit.holasek on 23.11.2016.
 */
public class OrderFacadeImpl implements OrderFacade {
    @Override
    public OrderDTO create(CreateOrderDTO order) {
        return null;
    }

    @Override
    public void update(UpdateOrderDTO order) {

    }

    @Override
    public void delete(OrderDTO order) {

    }

    @Override
    public OrderDTO findOrderById(Long orderId) {
        return null;
    }

    @Override
    public List<OrderDTO> findUserOrders(Long userId) {
        return null;
    }

    @Override
    public List<OrderDTO> findAllOrders() {
        return null;
    }

    @Override
    public OrderBillingDTO getOrderBilling(Long orderId) {
        return null;
    }

    @Override
    public void confirmPayment(Long orderId) {

    }
}
