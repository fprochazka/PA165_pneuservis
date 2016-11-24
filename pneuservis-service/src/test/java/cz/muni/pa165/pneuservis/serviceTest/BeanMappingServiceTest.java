package cz.muni.pa165.pneuservis.serviceTest;

import cz.fi.muni.pa165.pneuservis.dto.ServiceDTO;
import cz.fi.muni.pa165.pneuservis.entity.Service;
import cz.fi.muni.pa165.pneuservis.service.configuration.ServiceConfiguration;
import cz.fi.muni.pa165.pneuservis.service.services.BeanMappingService;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * @author Ivan Moscovic
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class BeanMappingServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private BeanMappingService beanMappingService;

    private Service service;

    private ServiceDTO serviceDTO;

    @BeforeClass
    public void setUp() {

        service = new Service();
        service.setDuration(5);
        service.setNameOfService("change of gear");
        service.setOwnParts(true);

        serviceDTO = new ServiceDTO();
        serviceDTO.setOwnParts(true);
        serviceDTO.setNameOfService("change of gear");
        serviceDTO.setDuration(5);
    }

    @Test
    public void serviceToServiceDTOTest() {

        final Service result = beanMappingService.mapTo(serviceDTO, Service.class);
        Assert.assertNotNull(result);
        Assert.assertEquals(serviceDTO.getDuration(), result.getDuration());
        Assert.assertEquals(serviceDTO.getNameOfService(), result.getNameOfService());
    }

    @Test
    public void serviceDTOToServiceTest() {

        final ServiceDTO result = beanMappingService.mapTo(service, ServiceDTO.class);
        Assert.assertNotNull(result);
        Assert.assertEquals(service.getDuration(), result.getDuration());
        Assert.assertEquals(service.getNameOfService(), result.getNameOfService());
    }
}