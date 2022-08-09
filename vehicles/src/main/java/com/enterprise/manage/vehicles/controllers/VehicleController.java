package com.enterprise.manage.vehicles.controllers;

import com.enterprise.manage.vehicles.models.FuelType;
import com.enterprise.manage.vehicles.models.Vehicle;
import com.enterprise.manage.vehicles.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping("{license}")
    public ResponseEntity<Vehicle> getAVehicle(@PathVariable String license) {
        Optional<Vehicle> vehicleDB = vehicleRepository.findByLicense(license);

        if (vehicleDB == null) {
            throw new NoSuchElementException("Item not found");
        }

        return ResponseEntity.ok(vehicleDB.get());
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Vehicle> createAVehicle(@RequestBody Vehicle vehicle ) {
        Locale locale = new Locale("", vehicle.getCountryCode());
        vehicle.setCountryCode(locale.getDisplayName());
        vehicle.setFuelType(FuelType.Diesel);
        vehicle.setNumberOfDoors(2);
        vehicle.setPower(10);
        Vehicle newVehicle = vehicleRepository.save(vehicle);
        return ResponseEntity.ok(newVehicle);

    }

    @PutMapping("{license}")
    public ResponseEntity<Vehicle> updateAVehicle(@PathVariable String license,
                                  @RequestBody Vehicle vehicle) {
        Optional<Vehicle> vehicleDB = vehicleRepository.findByLicense(license);

        if (vehicleDB == null) {
            throw new NoSuchElementException("Item not found");
        }
        vehicleDB.get().setRiskFactor(2.00);
        Vehicle updatedVehicle = vehicleRepository.save(vehicleDB.get());
        return ResponseEntity.ok(updatedVehicle);

    }
}
