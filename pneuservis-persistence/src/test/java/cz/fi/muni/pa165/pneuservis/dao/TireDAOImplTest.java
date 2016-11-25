package cz.fi.muni.pa165.pneuservis.dao;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cz.fi.muni.pa165.pneuservis.PersistenceSampleApplicationContext;
import cz.fi.muni.pa165.pneuservis.dao.TireDAO;
import cz.fi.muni.pa165.pneuservis.entity.Tire;
import cz.fi.muni.pa165.pneuservis.enums.TireManufacturer;
import cz.fi.muni.pa165.pneuservis.enums.TireType;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author Matej Šípka
 */
@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class TireDAOImplTest extends AbstractTestNGSpringContextTests {

    @PersistenceContext
    public EntityManager entityManager;

    @Autowired
    private TireDAO tireDao;

    private Tire tire1;
    private Tire tire2;

    @BeforeMethod
    private void init() {

        tire1 = new Tire();
        tire2 = new Tire();

        tire1.setCatalogNumber(2556);
        tire1.setManufacturer(TireManufacturer.BARUM);
        tire1.setDiameter(17);
        tire1.setProfile(40);
        tire1.setTireSize(255);
        tire1.setType(TireType.SUMMER);
        tire1.setPrice(BigDecimal.valueOf(150));
        tire1.setTypeOfCar("Audi");

        tire2.setCatalogNumber(3565);
        tire2.setManufacturer(TireManufacturer.HANKOOK);
        tire2.setDiameter(20);
        tire2.setProfile(45);
        tire2.setTireSize(225);
        tire2.setType(TireType.WINTER);
        tire2.setPrice(BigDecimal.valueOf(250));
        tire2.setTypeOfCar("BMW");

    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createWithNullTest() {
        tireDao.create(null);
    }

    @Test
    public void createTireTest() {
        tireDao.create(tire1);
        tireDao.create(tire2);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createTireWithWrongDiameter() {
        tire1.setDiameter(-5);
        tireDao.create(tire1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createTireWithNullManufacturer() {
        tire1.setManufacturer(null);
        tireDao.create(tire1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void createTireWithNullType() {
        tire1.setType(null);
        tireDao.create(tire1);
    }

    @Test
    public void updateTireTest() {
        tireDao.create(tire1);
        tireDao.create(tire2);

        tire1.setManufacturer(TireManufacturer.FALKEN);
        tireDao.update(tire1);
        List<Tire> tiresResult = tireDao.findByManufacturer(tire1.getManufacturer());
        for (Tire tire : tiresResult) {
            Assert.assertEquals(tire.getManufacturer(), TireManufacturer.FALKEN);
        }

        tire1.setTireSize(235);
        tireDao.update(tire1);
        List<Tire> tiresSizeResult = tireDao.findBySize(tire1.getTireSize());
        for (Tire tire : tiresSizeResult) {
            Assert.assertEquals(tire.getTireSize(), 235);
        }

    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void updateTireWithNullManufacturer() {
        tireDao.create(tire1);
        tire1.setManufacturer(null);
        tireDao.update(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void updateTireWithWrongDiameter() {
        tire1.setDiameter(-5);
        tireDao.update(tire1);
    }

    @Test
    public void findByIdTest() {
        tireDao.create(tire1);
        tireDao.create(tire2);
        Tire found = tireDao.findById(tire1.getId());
        Assert.assertEquals(found, tire1);
        Assert.assertNotEquals(found, tire2);
        assertDeepEquals(found, tire1);
    }

    @Test
    public void deleteTest() {
        tireDao.create(tire1);
        tireDao.create(tire2);
        Assert.assertNotNull(tireDao.findById(tire1.getId()));
        tireDao.delete(tire1);
        Assert.assertNull(tireDao.findById(tire1.getId()));
        Assert.assertNotNull(tireDao.findById(tire2.getId()));
    }

    @Test
    public void findAllTest() {
        tireDao.create(tire1);
        tireDao.create(tire2);
        List<Tire> tires = tireDao.findAll();
        Assert.assertEquals(tires.size(), 2);
        assertDeepEquals(tires.get(0), tire1);
        assertDeepEquals(tires.get(1), tire2);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void deleteNullService() {
        tireDao.delete(null);
    }

    private void assertDeepEquals(Tire tire1, Tire tire2) {
        Assert.assertEquals(tire1.getCatalogNumber(), tire2.getCatalogNumber());
        Assert.assertEquals(tire1.getId(), tire2.getId());
        Assert.assertEquals(tire1.getManufacturer(), tire2.getManufacturer());
        Assert.assertEquals(tire1.getType(), tire2.getType());
    }

}
