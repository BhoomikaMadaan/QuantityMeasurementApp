package com.app.quantitymeasurement.model;

import com.app.quantitymeasurement.IMeasurable;

import lombok.Data;

@Data
public class QuantityRequestDTO<U extends IMeasurable> {

    private QuantityDTO<?> quantity1;

    private QuantityDTO<?> quantity2;
    
    public QuantityDTO<?> getQuantity1() {
        return quantity1;
    }

    public QuantityDTO<?> getQuantity2() {
        return quantity2;
    }

}
