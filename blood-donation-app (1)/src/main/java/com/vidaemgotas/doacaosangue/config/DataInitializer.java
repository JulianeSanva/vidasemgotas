package com.vidaemgotas.doacaosangue.config;

import com.vidaemgotas.doacaosangue.model.Location;
import com.vidaemgotas.doacaosangue.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final LocationRepository locationRepository;

    @Autowired
    public DataInitializer(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public void run(String... args) {
        // Inicializa dados apenas se não existirem locais cadastrados
        if (locationRepository.count() == 0) {
            // Adiciona alguns locais de doação
            locationRepository.save(new Location(
                "Hemocentro Central",
                "Av. Principal, 1000",
                "São Paulo",
                "SP",
                "(11) 3333-4444"
            ));
            
            locationRepository.save(new Location(
                "Hospital Santa Casa", 
                "Rua da Misericórdia, 500",
                "Rio de Janeiro",
                "RJ",
                "(21) 2222-3333"
            ));
            
            locationRepository.save(new Location(
                "Centro de Doação Vida Nova",
                "Av. das Flores, 250",
                "Belo Horizonte",
                "MG",
                "(31) 4444-5555"
            ));
            
            System.out.println("Locais de doação inicializados com sucesso!");
        }
    }
}

