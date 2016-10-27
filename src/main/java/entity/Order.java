/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author xbonco1
 * Order class
 */
@Entity
@Table(name="PROJECT_ORDER")
public class Order {    
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Long id;
    
    @NotNull
    @Column(nullable = false)
    private Long clientId;
    
    @NotNull
    @Column(nullable = false)
    private BigDecimal price;

 /*   @NotNull
    @Column(nullable = false)
    private List<Product> listOfProducts;
 */   
    @Basic(optional = true) 
    private String note;
    
    public Long getId() {
        return id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
/*
    public void addProduct(Product product){
        listOfProducts.add(product);
    }
    
    public List<Product> getAllProducts() {
        return listOfProducts;
    }
    
    public void setAllProducts(List<Product> products){
        this.listOfProducts = products;
    }
    */
    public String getNote()
    {
        return note;
    }
    
    public void setNote(String note)
    {
        this.note = note;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return id == order.id;

    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
}
