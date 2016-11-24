/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.pneuservis.dao;

import cz.fi.muni.pa165.pneuservis.entity.Tire;
import cz.fi.muni.pa165.pneuservis.enums.TireManufacturer;
import cz.fi.muni.pa165.pneuservis.enums.TireType;
import java.util.List;

/**
 *
 * @author Matej Sipka
 */
public interface TireDAO {

    /**
     * Create a new tire in the DB
     *
     * @param tire the Tire object
     * @throws IllegalArgumentException
     */
    Tire create(Tire tire) throws IllegalArgumentException;

    /**
     * Update a tire in the DB.
     *
     * @param tire
     */
    Tire update(Tire tire);

    /**
     * Delete a tire in the DB.
     *
     * @param tire
     */
    void delete(Tire tire);

    /**
     * Finds a tire accordin to a unique ID.
     *
     * @param id the tires ID
     * @return found tire or null if not found
     */
    Tire findById(Long id);

    /**
     * Finds all tires
     *
     * @return list of a found tires
     */
    List<Tire> findAll();

    /**
     * Finds a tires by the manufacturer
     *
     * @param manufacturer Manufacturer assigned to a tire.
     * @return list of a found tires
     */
    List<Tire> findByManufacturer(TireManufacturer manufacturer);

    /**
     * Finds a tires by the diameter
     *
     * @param diameter Diameter assigned to a tire.
     * @return list of a found tires
     */
    List<Tire> findByDiameter(int diameter);

    /**
     * Finds a tires by the size
     *
     * @param size Size assigned to a tire.
     * @return list of a found tires
     */
    List<Tire> findBySize(int size);

    /**
     * Finds a tires by the catalog number
     *
     * @param catalogNumber Catalog number assigned to a tire.
     * @return list of a found tires
     */
    List<Tire> findByCatalogNumber(int catalogNumber);

    /**
     * Finds a tires by the type
     *
     * @param type type assigned to a tire. Type can be winter, summer, all
     * season.
     * @return list of a found tires
     */
    List<Tire> findByType(TireType type);

    /**
     * Finds a tires by the profile
     *
     * @param profile Profile assigned to a tire.
     * @return list of a found tires
     */
    List<Tire> findByProfile(int profile);

}
