package cz.fi.muni.pa165.pneuservis.dto;

import cz.fi.muni.pa165.pneuservis.enums.PaymentType;

import java.util.List;
import java.util.Objects;

/**
 *  @author vit.holasek on 24.11.2016.
 */
public class CreateOrderDTO {

    private Long clientId;

    private List<ServiceDTO> listOfServices;

    private List<TireDTO> listOfTires;

    private String note;

    private PaymentType PaymentType;

    public CreateOrderDTO(Long clientId, List<ServiceDTO> listOfServices, String note, PaymentType paymentType) {
        this.clientId = clientId;
        this.listOfServices = listOfServices;
        this.note = note;
        PaymentType = paymentType;
    }

    public CreateOrderDTO() { }

    public CreateOrderDTO(List<ServiceDTO> listOfServices) {
        this.listOfServices = listOfServices;
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

    public cz.fi.muni.pa165.pneuservis.enums.PaymentType getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(cz.fi.muni.pa165.pneuservis.enums.PaymentType paymentType) {
        PaymentType = paymentType;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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
        return Objects.equals(getClientId(), that.getClientId()) &&
                Objects.equals(getNote(), that.getNote()) &&
                getPaymentType() == that.getPaymentType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientId(), getNote(), getPaymentType());
    }
}
