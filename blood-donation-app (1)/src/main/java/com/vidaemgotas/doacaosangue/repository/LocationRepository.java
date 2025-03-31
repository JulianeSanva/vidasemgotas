package com.vidaemgotas.doacaosangue.repository;

import com.vidaemgotas.doacaosangue.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    
    List<Location> findByCity(String city);
    
    List<Location> findByState(String state);
}

