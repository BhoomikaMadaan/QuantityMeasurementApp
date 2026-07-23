package com.app.quantitymeasurement.util;

import com.app.quantitymeasurement.IMeasurable;
import com.app.quantitymeasurement.LengthUnit;
import com.app.quantitymeasurement.TemperatureUnit;
import com.app.quantitymeasurement.VolumeUnit;
import com.app.quantitymeasurement.WeightUnit;

public class UnitResolver {

    public static IMeasurable getUnit(
            String unit){

        try {
            return LengthUnit.valueOf(unit);
        }
        catch(Exception e){}

        try {
            return WeightUnit.valueOf(unit);
        }
        catch(Exception e){}

        try {
            return TemperatureUnit.valueOf(unit);
        }
        catch(Exception e){}

        try {
            return VolumeUnit.valueOf(unit);
        }
        catch(Exception e){}

        throw new IllegalArgumentException(
                "Invalid Unit");
    }
}