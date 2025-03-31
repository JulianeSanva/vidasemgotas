package com.vidaemgotas.doacaosangue.service;

import com.vidaemgotas.doacaosangue.model.Location;
import com.vidaemgotas.doacaosangue.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
    
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
    
    public Optional<Location> getLocationById(Long id) {
        return locationRepository.findById(id);
    }
    
    public List<Location> getLocationsByCity(String city) {
        return locationRepository.findByCity(city);
    }
    
    public List<Location> getLocationsByState(String state) {
        return locationRepository.findByState(state);
    }
    
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }
    
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}

