/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.pa165.pneuservis.facadeTest;

import cz.fi.muni.pa165.pneuservis.dto.TireDTO;
import cz.fi.muni.pa165.pneuservis.entity.Tire;
import cz.fi.muni.pa165.pneuservis.enums.TireManufacturer;
import cz.fi.muni.pa165.pneuservis.enums.TireType;
import cz.fi.muni.pa165.pneuservis.facade.TireFacade;
import cz.fi.muni.pa165.pneuservis.service.configuration.ServiceConfiguration;
import cz.fi.muni.pa165.pneuservis.service.facade.TireFacadeImpl;
import cz.fi.muni.pa165.pneuservis.service.services.BeanMappingService;
import cz.fi.muni.pa165.pneuservis.service.services.BeanMappingServiceImpl;
import cz.fi.muni.pa165.pneuservis.service.services.TireService;
import java.math.BigDecimal;
import java.util.Arrays;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author Matej Šípka
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class TireFacadeImplTest extends AbstractTestNGSpringContextTests {

    @Mock
    private TireService tireService;

    @InjectMocks
    private TireFacade tireFacade = new TireFacadeImpl();

    @Spy
    @Autowired
    private BeanMappingService beanMappingService = new BeanMappingServiceImpl();

    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }

    private Tire tire1;
    private Tire tire2;

    private TireDTO tireDto1;
    private TireDTO tireDto2;

    @BeforeMethod
    public void init() {

        tire1 = new Tire();
        tire2 = new Tire();

        tireDto1 = new TireDTO();
        tireDto2 = new TireDTO();

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
        tire2.setProfile(55);
        tire2.setTireSize(205);
        tire2.setType(TireType.WINTER);
        tire2.setTypeOfCar("truck");

        tireDto1.setCatalogNumber(tire1.getCatalogNumber());
        tireDto1.setDescription(tire1.getDescription());
        tireDto1.setDiameter(tire1.getDiameter());
        tireDto1.setManufacturer(tire1.getManufacturer());
        tireDto1.setPrice(tire1.getPrice());
        tireDto1.setProfile(tire1.getProfile());
        tireDto1.setTireSize(tire1.getTireSize());
        tireDto1.setType(tire1.getType());
        tireDto1.setTypeOfCar(tire1.getTypeOfCar());

        tireDto2.setCatalogNumber(tire2.getCatalogNumber());
        tireDto2.setDescription(tire2.getDescription());
        tireDto2.setDiameter(tire2.getDiameter());
        tireDto2.setManufacturer(tire2.getManufacturer());
        tireDto2.setPrice(tire2.getPrice());
        tireDto2.setProfile(tire2.getProfile());
        tireDto2.setTireSize(tire2.getTireSize());
        tireDto2.setType(tire2.getType());
        tireDto2.setTypeOfCar(tire2.getTypeOfCar());

    }

    @BeforeMethod
    public void initMocksBehaviour() {

        // findById
        when(tireService.findById(0l)).thenReturn(null);
        when(tireService.findById(1l)).thenReturn(tire1);
        when(tireService.findById(2l)).thenReturn(tire2);

        //create
        when(tireService.create(tire1)).thenReturn(tire1);

        //findByCatalogNumber
        when(tireService.findByCatalogNumber(12)).thenReturn(Arrays.asList(tire1));
        when(tireService.findByCatalogNumber(13)).thenReturn(Arrays.asList(tire2));

        //find by size
        when(tireService.findBySize(255)).thenReturn(Arrays.asList(tire1));

        //findAll
        when(tireService.findAll()).thenReturn(Arrays.asList(tire1, tire2));

    }

}
