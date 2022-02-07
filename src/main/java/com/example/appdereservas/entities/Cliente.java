package com.example.appdereservas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nome;
    private String Sobrenome;
    private String Endereco;
    private String Email;
    private String  DDD;
    private String Telefone;
    private String Senha;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Servico> servicos = new ArrayList<>();



    public Cliente() {
    }

    public Cliente(Long id, String nome, String sobrenome, String endereco, String email, String DDD, String telefone, String senha) {
        this.id = id;
        this.Nome = nome;
        this.Sobrenome = sobrenome;
        this.Endereco = endereco;
        this.Email = email;
        this.DDD = DDD;
        this.Telefone = telefone;
        this.Senha = senha;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        Sobrenome = sobrenome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDDD() {
        return DDD;
    }

    public void setDDD(String DDD) {
        this.DDD = DDD;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "Nome='" + Nome + '\'' +
                ", Sobrenome='" + Sobrenome + '\'' +
                ", Endereco='" + Endereco + '\'' +
                ", Email='" + Email + '\'' +
                ", DDD='" + DDD + '\'' +
                ", Telefone='" + Telefone + '\'' +
                ", Senha='" + Senha + '\'' +
                '}';
    }

}
