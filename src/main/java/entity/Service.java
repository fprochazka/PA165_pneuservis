/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ivan Moscovic
 */



@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @NotNull
    @Column(nullable = false)
    private int duration;

    @NotNull
    @Column(nullable = false)
    private boolean ownParts;

    @NotNull
    @Column(nullable = false)
    private String nameOfService;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean hasOwnParts() {
        return ownParts;
    }

    public void setOwnParts(boolean ownParts) {
        this.ownParts = ownParts;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getNameOfService() {
        return nameOfService;
    }

    public void setNameOfService(String nameOfService) {
        this.nameOfService = nameOfService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service = (Service) o;

        return id == service.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
