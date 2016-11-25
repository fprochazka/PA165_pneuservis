/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.pneuservis.facade;

import cz.fi.muni.pa165.pneuservis.dto.TireDTO;
import cz.fi.muni.pa165.pneuservis.enums.TireManufacturer;
import cz.fi.muni.pa165.pneuservis.enums.TireType;
import java.util.List;

/**
 *
 * @author Matej Šípka
 */
public interface TireFacade {

    void create(TireDTO tire) throws IllegalArgumentException;

    void update(TireDTO tire);

    void delete(TireDTO tire);

    TireDTO findById(Long id);

    List<TireDTO> findAll();

    List<TireDTO> findByCatalogNumber(int catalogNumber);

    List<TireDTO> findByProfile(int profile);

    List<TireDTO> findByDiameter(int diameter);

    List<TireDTO> findBySize(int size);

    List<TireDTO> findByType(TireType type);

    List<TireDTO> findByManufacturer(TireManufacturer manufacturer);

}
