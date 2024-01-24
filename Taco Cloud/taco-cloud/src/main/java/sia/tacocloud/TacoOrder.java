package sia.tacocloud;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class TacoOrder {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Date placedAt;

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
        Long id,
        Date placedAt,
        String deliveryName,
        String deliveryStreet,
        String deliveryCity,
        String deliveryState,
        String deliveryZip,
        String ccNumber,
        String ccExpiration,
        BigDecimal ccCVV
    ) {
        this.id = id;
        this.placedAt = placedAt;
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
    public Long getId() {
        return this.id;
    }

    public Date getPlacedAt() {
        return this.placedAt;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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
    public void setId(Long id) {
        this.id = id;
    }

    public void setPlacedAt(Date placedAt) {
        this.placedAt = placedAt;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            placedAt,
            deliveryName,
            deliveryStreet,
            deliveryCity,
            deliveryState,
            deliveryZip,
            ccNumber,
            ccExpiration,
            ccCVV
        );
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        TacoOrder tacoOrder = (TacoOrder) that;
        return Objects.equals(id, tacoOrder.id);
    }
}
