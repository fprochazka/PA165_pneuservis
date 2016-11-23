/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.pneuservis.service.facade;

import cz.fi.muni.pa165.pneuservis.dto.PersonDTO;
import cz.fi.muni.pa165.pneuservis.entity.Person;
import cz.fi.muni.pa165.pneuservis.facade.PersonFacade;
import cz.fi.muni.pa165.pneuservis.service.services.BeanMappingService;
import cz.fi.muni.pa165.pneuservis.service.services.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Maros Staurovsky
 */
public class PersonFacadeImpl implements PersonFacade{
    
    @Autowired
    private PersonService personService;
    
    @Autowired
    private BeanMappingService beanMappingService;

    @Override
    public void create(PersonDTO personDto, String password) throws IllegalArgumentException {
        Person personEntity = beanMappingService.mapTo(personDto, Person.class);
        personService.create(personEntity, password);
    }

    @Override
    public PersonDTO update(PersonDTO person) {
        Person personEntity = personService.update(beanMappingService.mapTo(person, Person.class));
        return beanMappingService.mapTo(personEntity, PersonDTO.class);
    }

    @Override
    public void delete(PersonDTO person) {
        personService.delete(beanMappingService.mapTo(person, Person.class));
    }

    @Override
    public PersonDTO findById(long id) {
        return beanMappingService.mapTo(personService.findById(id), PersonDTO.class);
    }

    @Override
    public List<PersonDTO> findAll() {
        return beanMappingService.mapTo(personService.findAll(), PersonDTO.class);
    }
    
}
