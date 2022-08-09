package com.enterprise.manage.vehicles.models;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import java.util.Locale;


public class VehicleDTO extends Vehicle{

    @NotNull
    private String License;
    @NotNull
    private String countryCode;
    @NotNull
    private Double riskFactor;


    @Override
    public String toString() {
        return "VehicleDTO{" +
                "License='" + License + '\'' +
                ", countryCode=" + countryCode +
                ", riskFactor=" + riskFactor +
                '}';
    }


}
