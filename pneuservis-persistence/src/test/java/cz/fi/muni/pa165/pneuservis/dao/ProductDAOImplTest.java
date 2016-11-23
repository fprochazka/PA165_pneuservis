package cz.fi.muni.pa165.pneuservis.dao;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cz.fi.muni.pa165.pneuservis.dao.ProductDAO;
import cz.fi.muni.pa165.pneuservis.entity.Product;
import cz.fi.muni.pa165.pneuservis.entity.Service;
import cz.fi.muni.pa165.pneuservis.entity.Tire;
import cz.fi.muni.pa165.pneuservis.enums.TireManufacturer;
import cz.fi.muni.pa165.pneuservis.enums.TireType;
import java.math.BigDecimal;
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

/**
 *
 * @author Matej Šípka
 */
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class ProductDAOImplTest extends AbstractTestNGSpringContextTests {

    @PersistenceContext
    public EntityManager entityManager;

    @Autowired
    private ProductDAO productDao;

    private Product product1;
    private Product product2;

    private Tire tire1;

    private Service service1;

    @BeforeMethod
    private void init() {

        product1 = new Product();
        product1.setDescription("desc1");
        product1.setPrice(new BigDecimal(2000));
        product1.setTypeOfVehicle("osobne");

        product2 = new Product();
        product2.setDescription("2");
        product2.setPrice(new BigDecimal(2500));
        product2.setTypeOfVehicle("nakladne");

        tire1 = new Tire();
        tire1.setCatalogNumber(2556);
        tire1.setManufacturer(TireManufacturer.BARUM);
        tire1.setDiameter(17);
        tire1.setProfile(40);
        tire1.setSize(255);
        tire1.setType(TireType.SUMMER);
        tire1.setDescription("desc1");
        tire1.setPrice(new BigDecimal(2000));
        tire1.setTypeOfVehicle("osobne");

        service1 = new Service();
        service1.setDuration(5);
        service1.setNameOfService("Change of gear");
        service1.setOwnParts(false);
        service1.setDescription("2");
        service1.setPrice(new BigDecimal(2500));
        service1.setTypeOfVehicle("nakladne");

    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createWithNullTest() {
        productDao.create(null);
    }

    @Test
    public void createProductTest() {
        productDao.create(product1);
    }

    @Test
    public void createTireProductTest() {
        productDao.create(tire1);
    }

    @Test
    public void createServiceProductTest() {
        productDao.create(service1);
    }

    @Test
    public void findByDescription() {
        productDao.create(product1);
        productDao.create(product2);
        List<Product> found = productDao.findByDescription(product1.getDescription());
        Assert.assertEquals(found.get(0), product1);
        assertDeepEquals(found.get(0), product1);
    }

    @Test
    public void updateServiceTest() {
        productDao.create(product1);
        productDao.create(product2);

        product1.setTypeOfVehicle("osobne1");
        productDao.update(product1);
        Assert.assertEquals(productDao.findByVehicleType(product1.getTypeOfVehicle()).get(0).getTypeOfVehicle(), "osobne1");

        product1.setPrice(BigDecimal.TEN);
        productDao.update(product1);
        Assert.assertEquals(productDao.findByPrice(product1.getPrice()).get(0).getPrice(), BigDecimal.TEN);

        assertDeepEquals(productDao.findById(product1.getId()), product1);
    }

    @Test
    public void findAllTest() {
        productDao.create(product1);
        productDao.create(product2);
        List<Product> products = productDao.findAll();
        Assert.assertEquals(products.size(), 2);
        assertDeepEquals(products.get(0), product1);
        assertDeepEquals(products.get(1), product2);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void deleteNullService() {
        productDao.delete(null);
    }

    private void assertDeepEquals(Product product1, Product product2) {
        Assert.assertEquals(product1.getDescription(), product2.getDescription());
        Assert.assertEquals(product1.getPrice(), product2.getPrice());
        Assert.assertEquals(product1.getTypeOfVehicle(), product2.getTypeOfVehicle());
    }

}
