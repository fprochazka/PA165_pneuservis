
import dao.OrderDAO;
import entity.Order;
import entity.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jaroslav Bonco
 */
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class OrderDAOImplTest extends AbstractTestNGSpringContextTests{
    @PersistenceContext
    public EntityManager em;

    @Autowired
    private OrderDAO orderDao;

    private Order order1;
    private Order order2;
    
   // private Product product1;
  //  private Product product2;
        
   // private List products;
    
    @BeforeMethod
    private void init(){
        
        order1 = new Order();
        order2 = new Order();
        
  //      product1 = new Product();
  //      product2 = new Product();
  //      products = new ArrayList<Product>();
        
  //      products.add(product1);
  //      products.add(product2);        
        
        order1.setClientId(1L);
        order1.setPrice(new BigDecimal("100.0"));
  //      order1.setAllProducts(products);
        order1.setNote("Please");

        order2.setClientId(2L);
        order2.setPrice(new BigDecimal("100.0"));
  //      order2.setAllProducts(products);
        order2.setNote("Thank you");
    }
    
    @Test
    public void findByIdTest(){
        orderDao.create(order1);
        Order o1 = orderDao.findById(order1.getId());
        Assert.assertEquals(o1, order1);
        assertOrderEquals(o1, order1);
    }

    @Test
    public void findByNonexistingIdTest(){
        Assert.assertNull(orderDao.findById(new Long(1)));
    }

    @Test
    public void findAllTest(){
        orderDao.create(order1);
        orderDao.create(order2);
        List<Order> orders = orderDao.findAll();
        Assert.assertEquals(orders.size(), 2);
    }

    @Test
    public void updatePersonTest(){
        orderDao.create(order1);
        Order found = orderDao.findById(order1.getId());
        found.setNote("Time to update");
        orderDao.update(found);
        Order updated = orderDao.findById(found.getId());

        Assert.assertEquals(found.getNote(), updated.getNote());
        assertOrderEquals(found, updated);
    }

    @Test
    public void deleteTest(){
        orderDao.create(order1);
        Assert.assertNotNull(orderDao.findById(order1.getId()));
        orderDao.delete(order1);
        Assert.assertNull(orderDao.findById(order1.getId()));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void clientIdNullTest(){
        order1.setClientId(null);
        orderDao.create(order1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void priceNullTest(){
        order1.setPrice(null);
        orderDao.create(order1);
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void priceNegativeValueTest(){
        order1.setPrice(new BigDecimal("-5.0"));
        orderDao.create(order1);
    }
  /*  
   @Test(expectedExceptions = IllegalArgumentException.class)
    public void listOfProductsNullTest(){
        order1.setAllProducts(null);
        orderDao.create(order1);
    }
   */ 
    @Test
    public void noteNullTest(){
        order1.setNote(null);
        orderDao.create(order1);
    }
    
    private void assertOrderEquals(Order actual, Order expected){
        Assert.assertEquals(actual.getId(), expected.getId());
        Assert.assertEquals(actual.getClientId(), expected.getClientId());
        Assert.assertEquals(actual.getPrice(), expected.getPrice());
  //      Assert.assertEquals(actual.getAllProducts(), expected.getAllProducts());
        Assert.assertEquals(actual.getNote(), expected.getNote());
    }
}
