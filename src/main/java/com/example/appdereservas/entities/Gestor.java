package com.example.appdereservas.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gestor gestor = (Gestor) o;
        return id.equals(gestor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
