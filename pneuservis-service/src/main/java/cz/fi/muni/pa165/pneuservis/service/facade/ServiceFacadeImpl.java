package cz.fi.muni.pa165.pneuservis.service.facade;

import cz.fi.muni.pa165.pneuservis.dto.ServiceDTO;
import cz.fi.muni.pa165.pneuservis.entity.Service;
import cz.fi.muni.pa165.pneuservis.facade.ServiceFacade;
import cz.fi.muni.pa165.pneuservis.service.services.BeanMappingService;
import cz.fi.muni.pa165.pneuservis.service.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Ivan Moscovic on 23.11.2016.
 */
public class ServiceFacadeImpl implements ServiceFacade {

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private BeanMappingService beanMappingService;

    @Override
    public void create(ServiceDTO service) throws IllegalArgumentException {
        Service serviceEntity = beanMappingService.mapTo(service, Service.class);
        serviceService.create(serviceEntity);
    }

    @Override
    public void delete(ServiceDTO service) throws IllegalArgumentException {
        serviceService.delete(beanMappingService.mapTo(service, Service.class));
    }

    @Override
    public void update(ServiceDTO service) throws IllegalArgumentException {
        serviceService.update(beanMappingService.mapTo(service, Service.class));
    }

    @Override
    public ServiceDTO findById(long id) {
        return beanMappingService.mapTo(serviceService.findById(id), ServiceDTO.class);
    }

    @Override
    public List<ServiceDTO> findByName(String name) {
        List<Service> services = serviceService.findByName(name);
        if (services == null){
            return null;
        }
        else {
            return beanMappingService.mapTo(services, ServiceDTO.class);
        }
    }

    @Override
    public List<ServiceDTO> findAllServices() {
        List<Service> services = serviceService.findAllServices();
        if (services == null){
            return null;
        }
        else {
            return beanMappingService.mapTo(services, ServiceDTO.class);
        }
    }
}
