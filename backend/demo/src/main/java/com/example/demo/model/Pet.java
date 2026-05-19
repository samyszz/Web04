package com.example.demo.model; // Ajustado

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String especie;
    private String raca;
    private Integer idade;
    private String nomeDono;

    // Construtor vazio (obrigatório para o JPA)
    public Pet() {}

    // Getters e Setters (devem existir todos aqui abaixo)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }
    public String getRaca() { return raca; }
    public void setRaca(String raca) { this.raca = raca; }
    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }
    public String getNomeDono() { return nomeDono; }
    public void setNomeDono(String nomeDono) { this.nomeDono = nomeDono; }
}