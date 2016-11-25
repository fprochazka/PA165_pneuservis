/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.pneuservis.service.services;

import cz.fi.muni.pa165.pneuservis.entity.Tire;
import cz.fi.muni.pa165.pneuservis.enums.TireManufacturer;
import cz.fi.muni.pa165.pneuservis.enums.TireType;
import java.util.List;

/**
 *
 * @author Matej Šípka
 */
public interface TireService {

    Tire create(Tire tire) throws IllegalArgumentException;

    Tire update(Tire tire);

    void delete(Tire tire);

    Tire findById(Long id);

    List<Tire> findAll();

    List<Tire> findByCatalogNumber(int catalogNumber);

    List<Tire> findByProfile(int profile);

    List<Tire> findByDiameter(int diameter);

    List<Tire> findBySize(int size);

    List<Tire> findByType(TireType type);

    List<Tire> findByManufacturer(TireManufacturer manufacturer);

}
