package com.example.appdereservas.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Data
@Entity
public class Gestor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;
    private String Cpf;
    private String Email;
    private String Senha;
    private String Endereco;

    public Gestor() {
    }

    public Gestor(Long id, String name, String cpf, String email, String senha, String endereco) {
        this.id = id;
        this.Name = name;
        this.Cpf = cpf;
        this.Email = email;
        this.Senha = senha;
        this.Endereco = endereco;
    }

}
