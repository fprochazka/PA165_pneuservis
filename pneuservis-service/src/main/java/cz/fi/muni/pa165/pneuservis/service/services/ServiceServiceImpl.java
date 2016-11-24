package cz.fi.muni.pa165.pneuservis.service.services;

import cz.fi.muni.pa165.pneuservis.dao.ServiceDAO;
import cz.fi.muni.pa165.pneuservis.entity.Service;
import cz.fi.muni.pa165.pneuservis.service.exception.PneuservisPortalDataAccessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.PersistenceException;

import java.util.List;

/**
 * @author Ivan Moscovic on 23.11.2016.
 */
@org.springframework.stereotype.Service
@Transactional
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceDAO serviceDAO;

    @Override
    public void create(Service service) throws IllegalArgumentException {
        try {
            serviceDAO.create(service);
        } catch (IllegalArgumentException | NullPointerException | PersistenceException e){
            throw new PneuservisPortalDataAccessException("Cannot create service", e);
        }
    }

    @Override
    public void delete(Service service) throws IllegalArgumentException {
        try {
            serviceDAO.delete(service);
        } catch (IllegalArgumentException | NullPointerException | PersistenceException e){
            throw new PneuservisPortalDataAccessException("Cannot delete service", e);
        }
    }

    @Override
    public void update(Service service) throws IllegalArgumentException {
        try {
            serviceDAO.update(service);
        } catch (IllegalArgumentException | NullPointerException | PersistenceException e){
            throw new PneuservisPortalDataAccessException("Cannot update service", e);
        }
    }

    @Override
    public Service findById(long id) {
        try {
           return serviceDAO.findById(id);
        } catch (IllegalArgumentException | NullPointerException | PersistenceException e){
            throw new PneuservisPortalDataAccessException("Cannot find service by id", e);
        }
    }

    @Override
    public List<Service> findByName(String name) {
        try {
            return serviceDAO.findByName(name);
        } catch (IllegalArgumentException | NullPointerException | PersistenceException e){
            throw new PneuservisPortalDataAccessException("Cannot find service by name", e);
        }
    }

    @Override
    public List<Service> findAllServices() {
        try {
            return serviceDAO.findAllServices();
        } catch (IllegalArgumentException | NullPointerException | PersistenceException e){
            throw new PneuservisPortalDataAccessException("Cannot find all services", e);
        }
    }
}
