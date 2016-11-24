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
 * @author Matej Šípka
 */
public interface TireFacade {

    Long create(PersonDTO person, String password) throws IllegalArgumentException;

    PersonDTO update(PersonDTO person);

    void delete(PersonDTO person);

    PersonDTO findById(Long id);

    List<PersonDTO> findAll();

    public List<PersonDTO> findByFirstname(String firstname);

    public List<PersonDTO> findBySurname(String surname);

    public PersonDTO findPersonByLogin(String login);
}
