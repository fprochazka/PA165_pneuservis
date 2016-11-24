package cz.muni.pa165.pneuservis.facadeTest;

import cz.fi.muni.pa165.pneuservis.dto.ServiceDTO;
import cz.fi.muni.pa165.pneuservis.entity.Service;
import cz.fi.muni.pa165.pneuservis.facade.ServiceFacade;
import cz.fi.muni.pa165.pneuservis.service.configuration.ServiceConfiguration;
import cz.fi.muni.pa165.pneuservis.service.facade.ServiceFacadeImpl;
import cz.fi.muni.pa165.pneuservis.service.services.BeanMappingService;
import cz.fi.muni.pa165.pneuservis.service.services.BeanMappingServiceImpl;
import cz.fi.muni.pa165.pneuservis.service.services.ServiceService;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * @author Ivan Moscovic on 24.11.2016.
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class ServiceFacadeImplTest extends AbstractTestNGSpringContextTests {

    @Mock
    private ServiceService serviceService;

    @InjectMocks
    private ServiceFacade serviceFacade = new ServiceFacadeImpl();

    @Spy
    @Autowired
    private BeanMappingService beanMappingService = new BeanMappingServiceImpl();

    Service service1;
    Service service2;
    ServiceDTO serviceDTO1;
    ServiceDTO ServiceDTO2;
    List<ServiceDTO> serviceDTOs;

    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void init(){

        service1 = new Service();
        service2 = new Service();

        service1.setDuration(5);
        service1.setNameOfService("Change of gear");
        service1.setOwnParts(false);
        //service1.setTypeOfVehicle("Honda");
        //service1.setPrice(BigDecimal.valueOf(1400));

        service2.setDuration(2);
        service2.setNameOfService("Change of oil");
        service2.setOwnParts(true);
        //service2.setTypeOfVehicle("Subaru");
        //service2.setPrice(BigDecimal.valueOf(100));

        serviceDTO1 = new ServiceDTO();
        serviceDTO1.setDuration(5);
        serviceDTO1.setNameOfService("Change of gear");
        serviceDTO1.setOwnParts(false);
        //serviceDTO1.setTypeOfVehicle("Honda");
        //serviceDTO1.setPrice(BigDecimal.valueOf(1400));


    }


}
