/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.pa165.pneuservis.serviceTest;

import cz.fi.muni.pa165.pneuservis.dao.TireDAO;
import cz.fi.muni.pa165.pneuservis.entity.Tire;
import cz.fi.muni.pa165.pneuservis.enums.TireManufacturer;
import cz.fi.muni.pa165.pneuservis.enums.TireType;
import cz.fi.muni.pa165.pneuservis.service.configuration.ServiceConfiguration;
import cz.fi.muni.pa165.pneuservis.service.exception.PneuservisPortalDataAccessException;
import cz.fi.muni.pa165.pneuservis.service.services.TireService;
import cz.fi.muni.pa165.pneuservis.service.services.TireServiceImpl;
import java.math.BigDecimal;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Matej Šípka
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class TireServiceImplTest extends AbstractTestNGSpringContextTests {

    @Mock
    private TireDAO tireDAO;

    @InjectMocks
    private TireService tireService = new TireServiceImpl();

    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }

    private Tire tire1;
    private Tire tire2;

    @BeforeMethod
    public void prepare() {

        tire1 = new Tire();
        tire2 = new Tire();

        tire1.setCatalogNumber(12);
        tire1.setDescription("none");
        tire1.setDiameter(17);
        tire1.setManufacturer(TireManufacturer.HANKOOK);
        tire1.setPrice(BigDecimal.TEN);
        tire1.setProfile(55);
        tire1.setTireSize(255);
        tire1.setType(TireType.SUMMER);
        tire1.setTypeOfCar("personal");

        tire2.setCatalogNumber(13);
        tire2.setDescription("none");
        tire2.setDiameter(18);
        tire2.setManufacturer(TireManufacturer.FALKEN);
        tire2.setPrice(BigDecimal.TEN);
        tire2.setProfile(50);
        tire2.setTireSize(205);
        tire2.setType(TireType.WINTER);
        tire2.setTypeOfCar("truck");
    }

    @Test
    public void createTireTest() {
        tireService.create(tire1);
        verify(tireDAO).create(tire1);
    }

    @Test(expectedExceptions = PneuservisPortalDataAccessException.class)
    public void createIllegalTireTest() {
        when(tireDAO.create(tire2)).thenThrow(IllegalArgumentException.class);
        tireService.create(tire2);
    }

    @Test
    public void findTireByIdTest() {
        when(tireDAO.findById(1L)).thenReturn(tire1);
        Assert.assertEquals(tireService.findById(1L), tire1);

        when(tireDAO.findById(0L)).thenReturn(null);
        Assert.assertEquals(tireService.findById(0L), null);
    }

}
