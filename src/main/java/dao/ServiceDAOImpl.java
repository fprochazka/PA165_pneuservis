/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Service;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ivan Moscovic
 */

@Repository
public class ServiceDAOImpl implements ServiceDAO {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * create new service and store in database
     * @param service - service to be stored
     * @throws IllegalArgumentException - exeption if service has some illegal arguments
     */
    @Override
    public void create(Service service) throws IllegalArgumentException {
        if (service == null || service.getNameOfService() == null || service.getDuration() <= 0){
            throw new IllegalArgumentException("Service must have a name and positive duration");
        }
        else {
            entityManager.persist(service);
        }
    }

    /**
     * delete service from database
     * @param service - service to be deleted
     * @throws IllegalArgumentException - exception if service does not exist if database
     */
    @Override
    public void delete(Service service) throws IllegalArgumentException{
        if (service == null){
            throw new IllegalArgumentException("Cannot delete null service");
        }
        entityManager.remove(service);
    }

    /**
     * update service
     * @param service -service object with updated attributes
     * @throws IllegalArgumentException - throws if service has some illegal attributes
     */
    @Override
    public void update(Service service) throws IllegalArgumentException {
        if (service == null || service.getNameOfService() == null || service.getDuration() <= 0){
            throw new IllegalArgumentException("Service must have a name and positive duration");
        }
        else {
            entityManager.merge(service);
        }
    }

    /**
     * Find service by its ID
     * @param id of service
     * @return service with given id, if none is found, return null
     */
    @Override
    public Service findById(long id) {
        return entityManager.find(Service.class, id);
    }

    /**
     * Find service by its name
     * @param name of service
     * @return List of services with given name (if there are more)
     */
    @Override
    public List<Service> findByName(String name) {
        return entityManager.createQuery("SELECT service FROM Service service WHERE service.nameOfService LIKE :name",
                Service.class).setParameter("name", name).getResultList();
    }

    /**
     * List all available services
     * @return List of services
     */
    @Override
    public List<Service> findAllServices() {
        return entityManager.createQuery("SELECT service FROM Service service", Service.class).getResultList();
    }
}
