package sia.tacocloud;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class TacoOrder {
    @NotBlank(message = "Delivery name is required")
    private String deliveryName;

    @NotBlank(message = "Street is required")
    private String deliveryStreet;

    @NotBlank(message = "City is required")
    private String deliveryCity;

    @NotBlank(message = "State is required")
    private String deliveryState;

    @NotBlank(message = "Zip code is required")
    private String deliveryZip;

    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][4-9])$", message = "MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private BigDecimal ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public TacoOrder() {
    }

    public TacoOrder(
        String deliveryName,
        String deliveryStreet,
        String deliveryCity,
        String deliveryState,
        String deliveryZip,
        String ccNumber,
        String ccExpiration,
        BigDecimal ccCVV
    ) {
        this.deliveryName = deliveryName;
        this.deliveryStreet = deliveryStreet;
        this.deliveryCity = deliveryCity;
        this.deliveryState = deliveryState;
        this.deliveryZip = deliveryZip;
        this.ccNumber = ccNumber;
        this.ccExpiration = ccExpiration;
        this.ccCVV = ccCVV;
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

    public String getCcNumber() {
        return this.ccNumber;
    }

    public String getCcExpiration() {
        return this.ccExpiration;
    }

    public BigDecimal getCcCVV() {
        return this.ccCVV;
    }

    public List<Taco> getTacos() {
        return this.tacos;
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

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public void setCcExpiration(String ccExpiration) {
        this.ccExpiration = ccExpiration;
    }

    public void setCCCVV(BigDecimal ccCVV) {
        this.ccCVV = ccCVV;
    }

    public void addTaco(Taco taco) {
        tacos.add(taco);
    }

    @Override
    public String toString() {
        return String.format( 
            "\nDelivery address: [Name] = %s, [City] = %s\ncc details: [Number] = %s\nOrder count: [Tacos] = %d",
            this.deliveryName,
            this.deliveryCity,
            this.ccNumber,
            this.tacos.size());
    }
}
