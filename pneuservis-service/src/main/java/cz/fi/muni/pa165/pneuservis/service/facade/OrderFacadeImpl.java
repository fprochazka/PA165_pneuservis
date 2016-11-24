package cz.fi.muni.pa165.pneuservis.service.facade;

import cz.fi.muni.pa165.pneuservis.dto.CreateUpdateOrderDTO;
import cz.fi.muni.pa165.pneuservis.dto.OrderBillingDTO;
import cz.fi.muni.pa165.pneuservis.dto.OrderDTO;
import cz.fi.muni.pa165.pneuservis.facade.OrderFacade;

import java.util.List;

/**
 * Created by vit.holasek on 23.11.2016.
 */
public class OrderFacadeImpl implements OrderFacade {
    @Override
    public OrderDTO create(CreateUpdateOrderDTO order) throws IllegalArgumentException {
        return null;
    }

    @Override
    public void update(CreateUpdateOrderDTO order) throws IllegalArgumentException {

    }

    @Override
    public void delete(Long orderId) {

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
}
