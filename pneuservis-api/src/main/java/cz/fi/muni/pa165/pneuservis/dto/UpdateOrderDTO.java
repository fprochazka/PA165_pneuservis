package cz.fi.muni.pa165.pneuservis.dto;

import cz.fi.muni.pa165.pneuservis.enums.PaymentType;

import java.util.List;
import java.util.Objects;

/**
 * @author vit.holasek on 24.11.2016.
 */
public class UpdateOrderDTO {
    private Long id;

    private Long clientId;

    private List<ServiceDTO> listOfServices;

    private List<TireDTO> listOfTires;

    private String note;

    private PaymentType paymentType;

    private boolean paymentConfirmed;

    private boolean shipped;

    public UpdateOrderDTO(Long id, Long clientId, List<ServiceDTO> listOfServices, List<TireDTO> listOfTires, String note, PaymentType paymentType, boolean paymentConfirmed, boolean shipped) {
        this.id = id;
        this.clientId = clientId;
        this.listOfServices = listOfServices;
        this.listOfTires = listOfTires;
        this.note = note;
        this.paymentType = paymentType;
        this.paymentConfirmed = paymentConfirmed;
        this.shipped = shipped;
    }

    public UpdateOrderDTO() { }

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

    public List<ServiceDTO> getListOfServices() {
        return listOfServices;
    }

    public void setListOfServices(List<ServiceDTO> listOfServices) {
        this.listOfServices = listOfServices;
    }

    public List<TireDTO> getListOfTires() {
        return listOfTires;
    }

    public void setListOfTires(List<TireDTO> listOfTires) {
        this.listOfTires = listOfTires;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public boolean getPaymentConfirmed() {
        return paymentConfirmed;
    }

    public void setPaymentConfirmed(boolean paymentConfirmed) {
        this.paymentConfirmed = paymentConfirmed;
    }

    public boolean getShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateOrderDTO that = (UpdateOrderDTO) o;
        return getPaymentConfirmed() == that.getPaymentConfirmed() &&
                getShipped() == that.getShipped() &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getClientId(), that.getClientId()) &&
                Objects.equals(getListOfServices(), that.getListOfServices()) &&
                Objects.equals(getListOfTires(), that.getListOfTires()) &&
                Objects.equals(getNote(), that.getNote()) &&
                getPaymentType() == that.getPaymentType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getClientId(), getListOfServices(), getListOfTires(), getNote(), getPaymentType(), getPaymentConfirmed(), getShipped());
    }
}
