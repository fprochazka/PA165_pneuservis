/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.pneuservis.dao;

import cz.fi.muni.pa165.pneuservis.entity.Person;
import java.util.List;

/**
 *
 * @author Maros Staurovsky
 */
public interface PersonDAO {
    
    /**
     * This method is used to creates a new person
     * @param person creates new person based on parameter
     * @throws IllegalArgumentException if there is any constraint violated
     */
    
    public void create (Person person) throws IllegalArgumentException;
    
    /**
     * This method is used to update an existing person
     * @param person with filled, edited parameters
     * @return updated person
     */
    
    public Person update (Person person);
    
    /**
     * This method is used to delete existing person
     * @param person is existing person to be deleted
     * @throws IllegalArgumentException if person is null
     */
    
    public void delete (Person person);
    
    /**
     * Finds person based on his id
     * @param id is id of the specific person
     * @return person with selected id
     */
    
    public Person findById (long id);
    
    /**
     * Gets all people which exist at the time 
     * @return list of all people
     */
    
    public List<Person> findAll ();
    
    /**
     * Get all people with searched first name from DB
     * @param firstname of the person
     * @return list of people with firstname stored in DB
     */
    public List<Person> findByFirstname(String firstname);

    /**
     * Get all people with searched surname from DB
     * @param surname of the person
     * @return list of people with surname stored in DB
     */

    public List<Person> findBySurname(String surname);

    /**
     * Get all people with searched login from DB
     * @param login of the person
     * @return list of people with login stored in DB
     */

    public Person findByLogin (String login);
}
