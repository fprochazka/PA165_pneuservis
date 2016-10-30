/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Tire;
import enums.TireManufacturer;
import enums.TireType;
import java.util.List;

/**
 *
 * @author Matej Sipka
 */
public interface TireDAO {

    void create(Tire tire) throws IllegalArgumentException;

    void update(Tire tire);

    void delete(Tire tire);

    Tire findById(long id);

    List<Tire> findAll();

    List<Tire> findByManufacturer(TireManufacturer manufacturer);

    List<Tire> findByDiameter(int diameter);

    List<Tire> findBySize(int size);

    List<Tire> findByCatalogNumber(int catalogNumber);

    List<Tire> findByType(TireType type);

    List<Tire> findByProfile(int profile);

}
