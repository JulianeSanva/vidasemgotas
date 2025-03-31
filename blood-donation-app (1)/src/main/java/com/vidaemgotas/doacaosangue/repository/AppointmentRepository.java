package com.vidaemgotas.doacaosangue.repository;

import com.vidaemgotas.doacaosangue.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    
    List<Appointment> findByEmail(String email);
    
    List<Appointment> findByDateBetween(LocalDate startDate, LocalDate endDate);
    
    List<Appointment> findByLocationId(Long locationId);
}

