package cz.fi.muni.pa165.pneuservis.dto;

import java.util.Objects;

/**
 * Created by vit.holasek on 23.11.2016.
 */
public class OrderDTO {
    private Long id;

    private Long clientId;

    private String note;

    public OrderDTO(Long id, Long clientId, String note) {
        this.id = id;
        this.clientId = clientId;
        this.note = note;
    }

    public OrderDTO() { }

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
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(getId(), orderDTO.getId()) &&
                Objects.equals(getClientId(), orderDTO.getClientId()) &&
                Objects.equals(getNote(), orderDTO.getNote());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getClientId(), getNote());
    }
}
