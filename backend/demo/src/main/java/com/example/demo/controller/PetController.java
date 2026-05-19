package com.example.demo.controller;

import com.example.demo.model.Pet;
import com.example.demo.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
// Liberamos explicitamente os métodos que o navegador está bloqueando

public class PetController {

    @Autowired
    private PetRepository repository;

    @GetMapping
    public List<Pet> listAll() {
        return repository.findAll();
    }

    @PostMapping
    public Pet save(@RequestBody Pet pet) {
        return repository.save(pet);
    }

    @PutMapping("/{id}")
public Pet update(@PathVariable Long id, @RequestBody Pet petDetails) {
    // 1. Buscamos o pet no banco para garantir que ele existe nesta sessão do Java
    return repository.findById(id).map(pet -> {
        // 2. Atualizamos os campos manualmente (isso evita o erro de Optimistic Locking)
        pet.setNome(petDetails.getNome());
        pet.setEspecie(petDetails.getEspecie());
        pet.setRaca(petDetails.getRaca());
        pet.setIdade(petDetails.getIdade());
        pet.setNomeDono(petDetails.getNomeDono());
        
        // 3. Salvamos o objeto que o Hibernate já está monitorando
        return repository.save(pet);
    }).orElseThrow(() -> new RuntimeException("Pet não encontrado no banco atual com id: " + id));
}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}