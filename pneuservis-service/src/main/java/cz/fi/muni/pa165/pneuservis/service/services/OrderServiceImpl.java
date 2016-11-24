package cz.fi.muni.pa165.pneuservis.service.services;

import cz.fi.muni.pa165.pneuservis.dao.OrderDAO;
import cz.fi.muni.pa165.pneuservis.dao.ServiceDAO;
import cz.fi.muni.pa165.pneuservis.dao.TireDAO;
import cz.fi.muni.pa165.pneuservis.entity.Order;
import cz.fi.muni.pa165.pneuservis.service.exception.PneuservisPortalDataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vit.holasek on 24.11.2016.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDao;

    @Autowired
    private ServiceDAO serviceDAO;

    @Autowired
    private TireDAO tireDAO;

    @Override
    public Order create(Order order) throws PneuservisPortalDataAccessException {
        if (order == null) throw new IllegalArgumentException("Order is null.");
        order.setShipped(false);
        order.setPaymentConfirmed(false);
        try {
            orderDao.create(order);
        } catch (Throwable e) {
            throw new PneuservisPortalDataAccessException("Cannot create order", e);
        }
        return order;
    }

    @Override
    public void update(Order order) throws PneuservisPortalDataAccessException {
        if (order == null) throw new IllegalArgumentException("Order is null.");
        try {
            orderDao.create(order);
        } catch (Throwable e) {
            throw new PneuservisPortalDataAccessException("Cannot update order", e);
        }
    }

    @Override
    public void delete(Order order) throws PneuservisPortalDataAccessException {
        if (order == null) throw new IllegalArgumentException("Order is null.");
        try {
            orderDao.delete(order);
        } catch (Throwable e) {
            throw new PneuservisPortalDataAccessException("Cannot delete order", e);
        }
    }

    @Override
    public Order findOrderById(Long orderId) {
        return null;
    }

    @Override
    public List<Order> findUserOrders(Long userId) {
        return null;
    }

    @Override
    public List<Order> findAllOrders() {
        return null;
    }

    @Override
    public OrderBilling getOrderBilling(Long orderId) {
        return null;
    }

    @Override
    public void confirmPayment(Long orderId) {

    }
}
