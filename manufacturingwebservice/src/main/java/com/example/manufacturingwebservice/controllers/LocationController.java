package com.example.manufacturingwebservice.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.manufacturingwebservice.dto.LocationDTO;
import com.example.manufacturingwebservice.entities.Location;
import com.example.manufacturingwebservice.services.LocationService;

@RestController
@RequestMapping(path = "/locations")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("")
    public List<LocationDTO> getLocations() {
        return locationService.getAll();
    }

    @GetMapping("/{locationID}")
    public ResponseEntity<Location> getLocationById(@PathVariable short locationID) {
        Optional<Location> location = locationService.getLocationById(locationID);
        return location.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<LocationDTO> createLocation(@RequestBody LocationDTO locationDTO) {
        LocationDTO createdLocation = locationService.create(locationDTO);
        return ResponseEntity.ok(createdLocation);
    }

    @PutMapping("/{locationID}")
    public ResponseEntity<LocationDTO> updateLocation(@PathVariable short locationID, @RequestBody LocationDTO locationDTO) {
        Optional<LocationDTO> updatedLocation = locationService.update(locationID, locationDTO);
        return updatedLocation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
