/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Maros Staurovsky
 */
@Repository
public class PersonDAOImpl implements PersonDAO{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Person person) throws IllegalArgumentException {
        if(person.getFirstname()==null || person.getSurname() == null || person.getLogin() == null)
        {
            throw new IllegalArgumentException("Person cannot have null parameter");
        }
        else
        {
            em.persist(person);
        }
    }

    @Override
    public void update(Person person) {
        em.merge(person);
    }

    @Override
    public void delete(Person person) {
        em.remove(person);
    }

    @Override
    public Person FindById(long id) {
        return em.find(Person.class, id);
    }

    @Override
    public List<Person> FindAll() {
         return em.createQuery("select person from Person person", Person.class)
				.getResultList();
    }
    
}
