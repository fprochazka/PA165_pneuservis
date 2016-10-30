/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import enums.PersonType;
import enums.TireDiameter;
import enums.TireType;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Matej Sipka
 */
@Entity
@Table(name="TIRES")
public class Tire {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @NotNull
    @Enumerated
    @Column(nullable = false)
    private TireType type;

    @NotNull
    private int catalogNumber;

    @NotNull
    private int size;

    @NotNull
    private int profile;

    @NotNull
    @Enumerated
    private TireDiameter diameter;

    @NotNull
    @Column(nullable = false)
    private String manufacturer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TireType getType() {
        return type;
    }

    public void setType(TireType type) {
        this.type = type;
    }

    public int getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(int catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public TireDiameter getDiameter() {
        return diameter;
    }

    public void setDiameter(TireDiameter diameter) {
        this.diameter = diameter;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Tire tire = (Tire) o;

        return Objects.equals(id, tire.id);

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}
