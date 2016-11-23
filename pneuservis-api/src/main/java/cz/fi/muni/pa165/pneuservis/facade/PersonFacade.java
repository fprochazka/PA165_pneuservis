/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.pneuservis.facade;

import cz.fi.muni.pa165.pneuservis.dto.PersonDTO;
import java.util.List;

/**
 *
 * @author Maros Staurovsky
 */
public interface PersonFacade {
    /**
     * This method is used to creates a new person
     * @param person creates new person based on parameter
     * @param password is password to be used
     * @throws IllegalArgumentException if there is any constraint violated
     */
    
    void create (PersonDTO person, String password) throws IllegalArgumentException;
    
    /**
     * This method is used to update an existing person
     * @param person with filled, edited parameters
     * @return updated person
     */
    
    PersonDTO update (PersonDTO person);
    
    /**
     * This method is used to delete existing person
     * @param person is existing person to be deleted
     * @throws IllegalArgumentException if person is null
     */
    
    void delete (PersonDTO person);
    
    /**
     * Finds person based on his id
     * @param id is id of the specific person
     * @return person with selected id
     */
    
    PersonDTO findById (long id);
    
    /**
     * Gets all people which exist at the time 
     * @return list of all people
     */
    
    List<PersonDTO> findAll ();
}
