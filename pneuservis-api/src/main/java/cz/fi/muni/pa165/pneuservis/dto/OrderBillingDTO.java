package cz.fi.muni.pa165.pneuservis.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * @author vit.holasek on 23.11.2016.
 */
public class OrderBillingDTO {
    private Long orderId;

    private BigDecimal priceWithVAT;

    private BigDecimal price;

    private List<BillingItemDTO> billingItems;

    public OrderBillingDTO(Long orderId, BigDecimal priceWithVAT, BigDecimal price, List<BillingItemDTO> billingItems) {
        this.orderId = orderId;
        this.priceWithVAT = priceWithVAT;
        this.price = price;
        this.billingItems = billingItems;
    }

    public OrderBillingDTO() { }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPriceWithVAT() {
        return priceWithVAT;
    }

    public void setPriceWithVAT(BigDecimal priceWithVAT) {
        this.priceWithVAT = priceWithVAT;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<BillingItemDTO> getBillingItems() {
        return billingItems;
    }

    public void setBillingItems(List<BillingItemDTO> billingItems) {
        this.billingItems = billingItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderBillingDTO that = (OrderBillingDTO) o;
        return Objects.equals(getOrderId(), that.getOrderId()) &&
                Objects.equals(getPriceWithVAT(), that.getPriceWithVAT()) &&
                Objects.equals(getPrice(), that.getPrice()) &&
                Objects.equals(getBillingItems(), that.getBillingItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getPriceWithVAT(), getPrice(), getBillingItems());
    }
}
