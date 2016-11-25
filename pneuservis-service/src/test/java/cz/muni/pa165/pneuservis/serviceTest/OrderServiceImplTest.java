package cz.muni.pa165.pneuservis.serviceTest;

import cz.fi.muni.pa165.pneuservis.dao.OrderDAO;
import cz.fi.muni.pa165.pneuservis.service.configuration.ServiceConfiguration;
import cz.fi.muni.pa165.pneuservis.service.services.OrderService;
import cz.fi.muni.pa165.pneuservis.service.services.OrderServiceImpl;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeClass;

/**
 * Created by vit.holasek on 25.11.2016.
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class OrderServiceImplTest {
    @Mock
    private OrderDAO orderDao;

    @InjectMocks
    private OrderService orderService = new OrderServiceImpl();

    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }
}
