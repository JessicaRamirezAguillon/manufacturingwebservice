package com.example.manufacturingwebservice.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.manufacturingwebservice.dto.LocationDTO;
import com.example.manufacturingwebservice.entities.Location;
import com.example.manufacturingwebservice.services.LocationService;

@RestController
@RequestMapping(path = "/locations")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("")
    public List<LocationDTO> getLocationss() {
        return locationService.getAll();
    }

    @GetMapping("/{locationID}")
    public ResponseEntity<Location> getProductById(@PathVariable short locationID) {
        Optional<Location> location = locationService.getLocationById(locationID);
        return location.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<LocationDTO> createProduct(@RequestBody LocationDTO locationDTO) {
        LocationDTO createdLocation = locationService.create(locationDTO);
        return ResponseEntity.ok(createdLocation);
    }
}
