/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fi.muni.pa165.pneuservis.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author xbonco1 Order class
 */
@Entity
@Table(name = "PROJECT_ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Long clientId;

//    @NotNull
//    @Column(nullable = false)
//    @OneToMany(targetEntity = Product.class, cascade = {CascadeType.ALL})
//    private List<Product> listOfProducts;

    @Basic(optional = true)
    private String note;

    public Order(Long clientId, /* List<Product> listOfProducts,*/ String note) {
        this.clientId = clientId;
//        this.listOfProducts = listOfProducts;
        this.note = note;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

//    public void addProduct(Product product) {
//        listOfProducts.add(product);
//    }

//    public List<Product> getAllProducts() {
//        return listOfProducts;
//    }
//
//    public void setAllProducts(List<Product> products) {
//        this.listOfProducts = products;
//    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.clientId);
//        hash = 41 * hash + Objects.hashCode(this.listOfProducts);
        hash = 41 * hash + Objects.hashCode(this.note);
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
        final Order other = (Order) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.clientId, other.clientId)) {
            return false;
        }
//        if (!Objects.equals(this.listOfProducts, other.listOfProducts)) {
//            return false;
//        }
        if (!Objects.equals(this.note, other.note)) {
            return false;
        }
        return true;
    }

}
