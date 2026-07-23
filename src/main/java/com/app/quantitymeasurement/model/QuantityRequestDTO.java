package com.app.quantitymeasurement.model;

public class QuantityRequestDTO {

    private QuantityRequestItemDTO quantity1;
    private QuantityRequestItemDTO quantity2;

    public QuantityRequestItemDTO getQuantity1() {
        return quantity1;
    }

    public void setQuantity1(
            QuantityRequestItemDTO quantity1) {
        this.quantity1 = quantity1;
    }

    public QuantityRequestItemDTO getQuantity2() {
        return quantity2;
    }

    public void setQuantity2(
            QuantityRequestItemDTO quantity2) {
        this.quantity2 = quantity2;
    }
}