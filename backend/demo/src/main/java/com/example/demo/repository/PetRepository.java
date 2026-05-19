package com.example.demo.repository; // Ajustado

import com.example.demo.model.Pet; // O IMPORT QUE ESTAVA FALTANDO!
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}