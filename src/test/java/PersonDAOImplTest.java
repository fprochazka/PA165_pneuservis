/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import entity.Person;
import enums.PersonType;
import dao.PersonDAO;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 *
 * @author Maros Staurovsky
 */
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class PersonDAOImplTest extends AbstractTestNGSpringContextTests {

    @PersistenceContext
    public EntityManager em;

    @Autowired
    private PersonDAO personDao;

    private Person person1;
    private Person person2;

    @BeforeMethod
    private void init(){
        
        person1 = new Person();
        person2 = new Person();
        
        person1.setFirstname("John");
        person1.setSurname("Green");
        person1.setPersonType(PersonType.CLIENT);
        person1.setLogin("person.one");
        person1.setDateOfBirth(Calendar.getInstance());

        person2.setFirstname("Sally");
        person2.setSurname("Orange");
        person2.setPersonType(PersonType.CLIENT);
        person2.setLogin("person.two");
        person2.setDateOfBirth(Calendar.getInstance());
    }

    @Test
    public void findByIdTest(){
        personDao.create(person1);
        Person h1 = personDao.FindById(person1.getId());
        Assert.assertEquals(h1, person1);
        assertPersonEquals(h1, person1);
    }

    @Test
    public void findByNonexistingIdTest(){
        Assert.assertNull(personDao.FindById(new Long(1)));
    }

    @Test
    public void findAllTest(){
        personDao.create(person1);
        personDao.create(person2);
        Assert.assertEquals(personDao.FindAll().size(), 2);
    }

    @Test
    public void updatePersonTest(){
        personDao.create(person1);
        personDao.create(person2);
        Person found = personDao.FindById(person1.getId());
        found.setFirstname(found.getFirstname());
        personDao.update(found);
        Person updated = personDao.FindById(found.getId());

        Assert.assertEquals(found.getFirstname(), updated.getFirstname());
        assertPersonEquals(found, updated);
    }

    @Test
    public void deleteTest(){
        personDao.create(person1);
        personDao.create(person2);
        Assert.assertNotNull(personDao.FindById(person1.getId()));
        personDao.delete(person1);
        Assert.assertNull(personDao.FindById(person1.getId()));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void firstnameNullTest(){
        person1.setFirstname(null);
        personDao.create(person1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void surnameNullTest(){
        person1.setSurname(null);
        personDao.create(person1);
    }

    private void assertPersonEquals(Person actual, Person expected){
        Assert.assertEquals(actual.getId(), expected.getId());
        Assert.assertEquals(actual.getFirstname(), expected.getFirstname());
        Assert.assertEquals(actual.getSurname(), expected.getSurname());
        Assert.assertEquals(actual.getPersonType(), expected.getPersonType());
        Assert.assertEquals(actual.getLogin(), expected.getLogin());
        Assert.assertEquals(actual.getDateOfBirth(), expected.getDateOfBirth());
    }

}
