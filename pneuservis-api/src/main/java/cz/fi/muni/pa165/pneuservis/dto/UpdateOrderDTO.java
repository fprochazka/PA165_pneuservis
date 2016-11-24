package cz.fi.muni.pa165.pneuservis.dto;

import cz.fi.muni.pa165.pneuservis.enums.PaymentType;

import java.util.List;
import java.util.Objects;

/**
 * Created by vit.holasek on 24.11.2016.
 */
public class UpdateOrderDTO {
    private Long id;

    private Long clientId;

    private List<Long> listOfProducts;

    private String note;

    private PaymentType paymentType;

    private boolean PaymentConfirmed;

    private boolean shipped;

    public UpdateOrderDTO(Long id, Long clientId, List<Long> listOfProducts, String note, PaymentType paymentType, boolean paymentConfirmed, boolean shipped) {
        this.id = id;
        this.clientId = clientId;
        this.listOfProducts = listOfProducts;
        this.note = note;
        this.paymentType = paymentType;
        PaymentConfirmed = paymentConfirmed;
        this.shipped = shipped;
    }

    public UpdateOrderDTO() { }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateOrderDTO that = (UpdateOrderDTO) o;
        return PaymentConfirmed == that.PaymentConfirmed &&
                shipped == that.shipped &&
                Objects.equals(id, that.id) &&
                Objects.equals(clientId, that.clientId) &&
                Objects.equals(listOfProducts, that.listOfProducts) &&
                Objects.equals(note, that.note) &&
                paymentType == that.paymentType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, listOfProducts, note, paymentType, PaymentConfirmed, shipped);
    }
}
