package cz.fi.muni.pa165.pneuservis.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by vit.holasek on 24.11.2016.
 */
public class BillingItemDTO {
    private String description;

    private int VAT;

    private BigDecimal priceWithVAT;

    private BigDecimal price;

    public BillingItemDTO(String description, Integer vat, BigDecimal priceWithVAT, BigDecimal price) {
        this.description = description;
        VAT = vat;
        this.priceWithVAT = priceWithVAT;
        this.price = price;
    }

    public BillingItemDTO() { }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVAT() {
        return VAT;
    }

    public void setVAT(int VAT) {
        this.VAT = VAT;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillingItemDTO that = (BillingItemDTO) o;
        return Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getVAT(), that.getVAT()) &&
                Objects.equals(getPriceWithVAT(), that.getPriceWithVAT()) &&
                Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), getVAT(), getPriceWithVAT(), getPrice());
    }
}
