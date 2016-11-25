package cz.fi.muni.pa165.pneuservis.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Ivan Moscovic on 23.11.2016.
 */
public class ServiceDTO {

    private Long id;

    @NotNull
    @Min(0)
    private int duration;

    @Size(min=1, max=250)
    private String description;

    @NotNull
    @Min(0)
    private BigDecimal price;

    @NotNull
    private String typeOfCar;

    @NotNull
    private boolean ownParts;

    @NotNull
    @Size(min=1, max=250)
    private String nameOfService;

    public ServiceDTO(int duration, boolean ownParts, String nameOfService,
                            BigDecimal price, String description, String typeOfCar) {
        this.duration = duration;
        this.ownParts = ownParts;
        this.nameOfService = nameOfService;
        this.price = price;
        this.description = description;
        this.typeOfCar = typeOfCar;
    }

    public ServiceDTO() {
    }

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean hasOwnParts() {
        return ownParts;
    }

    public void setOwnParts(boolean ownParts) {
        this.ownParts = ownParts;
    }

    public String getNameOfService() {
        return nameOfService;
    }

    public void setNameOfService(String nameOfService) {
        this.nameOfService = nameOfService;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null ||  !(o instanceof ServiceDTO)) return false;
        final ServiceDTO service = (ServiceDTO) o;

        if (!Objects.equals(this.nameOfService, service.getNameOfService())) {
            return false;
        }
        if (!Objects.equals(this.duration, service.getDuration())) {
            return false;
        }
        if (!Objects.equals(this.ownParts, service.hasOwnParts())) {
            return false;
        }
        if (!Objects.equals(this.price, service.price)) {
            return false;
        }
        if (!Objects.equals(this.typeOfCar, service.getTypeOfCar())) {
            return false;
        }
        if (!Objects.equals(this.id, service.getId())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.duration);
        hash = 89 * hash + Objects.hashCode(this.ownParts);
        hash = 89 * hash + Objects.hashCode(this.nameOfService);
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.typeOfCar);
        hash = 89 * hash + Objects.hashCode(this.price);

        return hash;
    }

}
