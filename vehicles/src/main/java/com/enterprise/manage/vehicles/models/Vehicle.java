package com.enterprise.manage.vehicles.models;


import com.enterprise.manage.vehicles.exceptions.NegativeNumbersNotAllowedException;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Locale;
import java.util.Locale.IsoCountryCode;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String license;
    private String countryCode;
    private Double riskFactor;
    private Integer numberOfDoors;
    private FuelType fuelType;
    private Integer power;

    public Vehicle() {
    }

    public Vehicle(String license, String countryCode, Double riskFactor) {
        this.license = license;
        this.countryCode = countryCode;
        this.riskFactor = riskFactor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Double getRiskFactor() {
        return riskFactor;
    }

    public void setRiskFactor(Double riskFactor) {
        this.riskFactor = riskFactor;
    }

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        if (numberOfDoors < 0){
            throw new NegativeNumbersNotAllowedException("Please enter a valid number of doors.");
        }
        this.numberOfDoors = numberOfDoors;
    }

    public Enum getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        if (power < 0) {
            throw new NegativeNumbersNotAllowedException("Please enter a valid number for power.");
        }
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;

        Vehicle vehicle = (Vehicle) o;

        return id != null ? id.equals(vehicle.id) : vehicle.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", License='" + license + '\'' +
                ", countryCode=" + countryCode +
                ", riskFactor=" + riskFactor +
                ", numberOfDoors=" + numberOfDoors +
                ", fuelType=" + fuelType +
                ", power=" + power +
                '}';
    }

}
