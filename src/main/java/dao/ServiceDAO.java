/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Service;

import java.util.List;

/**
 *
 * @author Ivan Moscovic
 */
public interface ServiceDAO {

    public void create(Service service) throws IllegalArgumentException;

    public void delete(Service service) throws IllegalArgumentException;

    public void update(Service service) throws IllegalArgumentException;

    public Service findById(long id);

    public List<Service> findByName(String name);

    public List<Service> getAllServices();

}
