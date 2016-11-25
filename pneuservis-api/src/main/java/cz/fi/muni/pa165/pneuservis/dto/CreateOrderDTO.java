package cz.fi.muni.pa165.pneuservis.dto;

import cz.fi.muni.pa165.pneuservis.enums.PaymentType;

import java.util.List;
import java.util.Objects;

/**
 * Created by vit.holasek on 24.11.2016.
 */
public class CreateOrderDTO {
    private Long id;

    private Long clientId;

    private List<Long> listOfProducts;

    private String note;

    private PaymentType PaymentType;

    public CreateOrderDTO(Long id, Long clientId, List<Long> listOfProducts, String note, PaymentType paymentType) {
        this.id = id;
        this.clientId = clientId;
        this.listOfProducts = listOfProducts;
        this.note = note;
        PaymentType = paymentType;
    }

    public CreateOrderDTO() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<Long> getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(List<Long> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateOrderDTO that = (CreateOrderDTO) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getClientId(), that.getClientId()) &&
                Objects.equals(getListOfProducts(), that.getListOfProducts()) &&
                Objects.equals(getNote(), that.getNote()) &&
                PaymentType == that.PaymentType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getClientId(), getListOfProducts(), getNote(), PaymentType);
    }
}