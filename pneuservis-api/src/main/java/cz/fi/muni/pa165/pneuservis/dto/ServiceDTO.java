package cz.fi.muni.pa165.pneuservis.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Ivan Moscovic on 23.11.2016.
 */
public class ServiceDTO {

    private int duration;
    private boolean ownParts;
    private String nameOfService;

    public ServiceDTO(int duration, boolean ownParts, String nameOfService,
                      BigDecimal price, String description, String typeOfVehicle) {
        //super(price, description, typeOfVehicle);
        this.duration = duration;
        this.ownParts = ownParts;
        this.nameOfService = nameOfService;
    }

    public ServiceDTO() {
        super();
    }

    public boolean hasOwnParts() {
        return ownParts;
    }

    public void setOwnParts(boolean ownParts) {
        this.ownParts = ownParts;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getNameOfService() {
        return nameOfService;
    }

    public void setNameOfService(String nameOfService) {
        this.nameOfService = nameOfService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

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
        /*if (!Objects.equals(super.getId(), service.getId())) {
            return false;
        }*/
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.duration);
        hash = 89 * hash + Objects.hashCode(this.ownParts);
        hash = 89 * hash + Objects.hashCode(this.nameOfService);
        //hash = 89 * hash + Objects.hashCode(super.getId());

        return hash;
    }
}
