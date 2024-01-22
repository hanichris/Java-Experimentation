package sia.tacocloud;

import java.util.ArrayList;
import java.util.List;

public class TacoOrder {
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public TacoOrder() {
        deliveryName = "";
        deliveryState = "";
        deliveryCity = "";
        deliveryState = "";
        deliveryZip = "";
        ccNumber = "";
        ccExpiration = "";
        ccCVV = "";
    }

    public TacoOrder(
        String deliveryName,
        String deliveryStreet,
        String deliveryCity,
        String deliveryState,
        String deliveryZip,
        String ccNumber,
        String ccExpiration,
        String ccCvv
    ) {
        this.deliveryName = deliveryName;
        this.deliveryStreet = deliveryStreet;
        this.deliveryCity = deliveryCity;
        this.deliveryState = deliveryState;
        this.deliveryZip = deliveryZip;
        this.ccNumber = ccNumber;
        this.ccExpiration = ccExpiration;
        this.ccCVV = ccCvv;
    }

    // Getter methods
    public String getDeliveryName() {
        return this.deliveryName;
    }

    public String getDeliveryStreet() {
        return this.deliveryStreet;
    }
    
    public String getDeliveryCity() {
        return this.deliveryCity;
    }

    public String getDeliveryState() {
        return this.deliveryState;
    }

    public String getDeliveryZip() {
        return this.deliveryZip;
    }

    public String getCCNumber() {
        return this.ccNumber;
    }

    public String getCCExpiration() {
        return this.ccExpiration;
    }

    public String getCCCVV() {
        return this.ccCVV;
    }

    // Setter methods
    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public void setDeliveryStreet(String deliveryStreet) {
        this.deliveryStreet = deliveryStreet;
    }
    
    public void setDeliveryCity(String deliveryCity) {
        this.deliveryCity = deliveryCity;
    }

    public void setDeliveryState(String deliveryState) {
        this.deliveryState = deliveryState;
    }

    public void setDeliveryZip(String deliveryZip) {
        this.deliveryZip = deliveryZip;
    }

    public void setCCNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public void setCCExpiration(String ccExpiration) {
        this.ccExpiration = ccExpiration;
    }

    public void setCCCVV(String ccCVV) {
        this.ccCVV = ccCVV;
    }


    public void addTaco(Taco taco) {
        tacos.add(taco);
    }
}