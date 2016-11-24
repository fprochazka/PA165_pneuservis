/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.pneuservis.dto;

import cz.fi.muni.pa165.pneuservis.enums.TireManufacturer;
import cz.fi.muni.pa165.pneuservis.enums.TireType;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Matej Šípka
 */
public class TireDTO {

    @NotNull
    private TireType type;

    @NotNull
    private int catalogNumber;

    @NotNull
    private int tireSize;

    @NotNull
    private int profile;

    @NotNull
    private int diameter;

    @NotNull
    private TireManufacturer manufacturer;

    public TireDTO(TireType type, int catalogNumber, int tireSize, int diameter, TireManufacturer manufacturer, BigDecimal price, String description, String typeOfVehicle) {
//        super(price, description, typeOfVehicle);
        this.type = type;
        this.catalogNumber = catalogNumber;
        this.tireSize = tireSize;
        this.diameter = diameter;
        this.manufacturer = manufacturer;
    }

}
