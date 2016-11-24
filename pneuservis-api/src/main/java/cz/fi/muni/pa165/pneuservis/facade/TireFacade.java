/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.pneuservis.facade;

import cz.fi.muni.pa165.pneuservis.dto.TireDTO;
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
    
    List<TireDTO> findByCatalogNumber();
    
    List<TireDTO> findByProfile();
    
    List<TireDTO> findByDiameter();
    
    List<TireDTO> findBySize();
    
    List<TireDTO> findByType();
    
    List<TireDTO> findByManufacturer();
    
}
