/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.pneuservis.entity;

import cz.fi.muni.pa165.pneuservis.enums.TireManufacturer;
import cz.fi.muni.pa165.pneuservis.enums.TireType;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Matej Sipka
 */
@Entity
public class Tire extends Product {

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TireType type;

    @NotNull
    @Column(unique = true)
    private int catalogNumber;

    @NotNull
    private int tireSize;

    @NotNull
    private int profile;

    @NotNull
    private int diameter;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TireManufacturer manufacturer;

    public Tire(TireType type, int catalogNumber, int tireSize, int diameter, TireManufacturer manufacturer, BigDecimal price, String description, String typeOfVehicle) {
        super(price, description, typeOfVehicle);
        this.type = type;
        this.catalogNumber = catalogNumber;
        this.tireSize = tireSize;
        this.diameter = diameter;
        this.manufacturer = manufacturer;
    }

    public Tire() {
        super();
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
        return tireSize;
    }

    public void setSize(int size) {
        this.tireSize = size;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public TireManufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(TireManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.type);
        hash = 29 * hash + this.catalogNumber;
        hash = 29 * hash + this.tireSize;
        hash = 29 * hash + this.profile;
        hash = 29 * hash + this.diameter;
        hash = 29 * hash + Objects.hashCode(this.manufacturer);
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
        final Tire other = (Tire) obj;
        if (this.type != other.type) {
            return false;
        }
        if (this.catalogNumber != other.catalogNumber) {
            return false;
        }
        if (this.tireSize != other.tireSize) {
            return false;
        }
        if (this.profile != other.profile) {
            return false;
        }
        if (this.diameter != other.diameter) {
            return false;
        }
        if (this.manufacturer != other.manufacturer) {
            return false;
        }
        return true;
    }

}
