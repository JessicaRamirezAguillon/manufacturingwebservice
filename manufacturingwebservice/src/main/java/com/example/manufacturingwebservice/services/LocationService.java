package com.example.manufacturingwebservice.services;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manufacturingwebservice.dto.LocationDTO;
import com.example.manufacturingwebservice.entities.Location;
import com.example.manufacturingwebservice.repositories.LocationRepository;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<LocationDTO> getAll() {
        List<Location> locations = locationRepository.findAll();
        return locations.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<Location> getLocationById(short locationID) {
        return locationRepository.findById(locationID);
    }

    public LocationDTO create(LocationDTO locationDTO) {
        Location location = modelMapper.map(locationDTO, Location.class);
        Location savedLocation = locationRepository.save(location);
        return convertToDto(savedLocation);
    }

    public Optional<LocationDTO> update(short locationID, LocationDTO locationDTO) {
        return locationRepository.findById(locationID).map(existingLocation -> {
            modelMapper.map(locationDTO, existingLocation);
            Location updatedLocation = locationRepository.save(existingLocation);
            return convertToDto(updatedLocation);
        });
    }

    private LocationDTO convertToDto(Location location) {
        return modelMapper.map(location, LocationDTO.class);
    }
}
