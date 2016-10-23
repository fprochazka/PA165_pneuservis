/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import enums.PersonType;
import java.util.Calendar;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Maros Staurovsky
 */
public class Person {
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Calendar DateOfBirth;
    
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Long id;
    
    @NotNull
    @Enumerated
    private PersonType type;
    
    @NotNull
    @Column(nullable = false)
    private String firstname;

    @NotNull
    @Column(nullable = false)
    private String surname;
    
    @NotNull
    private String login;
    
    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public Calendar getDateOfBirth()
    {
        return DateOfBirth;
    }
    
    public void setDateOfBirth(Calendar DoB)
    {
        this.DateOfBirth = DoB;
    }
    
    public PersonType getPersonType()
    {
        return type;
    }
    
    public void setPersonType(PersonType type)
    {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        return !(!Objects.equals(this.id, other.id) && (this.id == null || !this.id.equals(other.id)));
    }
    
    
}
