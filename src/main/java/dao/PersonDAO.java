/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Person;
import java.util.List;

/**
 *
 * @author Maros Staurovsky
 */
public interface PersonDAO {
    
    public void create (Person person) throws IllegalArgumentException;
    
    public void update (Person person);
    
    public void delete (Person person);
    
    public Person findById (long id);
    
    public List<Person> FindAll ();
}
