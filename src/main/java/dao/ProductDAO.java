/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Product;

/**
 *
 * @author Matej Šípka
 */
public interface ProductDAO {

    void create(Product product) throws IllegalArgumentException;

    void update(Product product) throws IllegalArgumentException;

    void delete(Product product) throws IllegalArgumentException;

    Product findById(long id);
}
