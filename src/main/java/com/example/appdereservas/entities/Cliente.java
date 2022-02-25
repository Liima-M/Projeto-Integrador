package com.example.appdereservas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sobrenome;
    private String endereco;
    private String email;
    private String ddd;
    private String telefone;
    private String senha;

//    @OneToOne
//    private Carrinho carrinho;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas = new ArrayList<>();



    public Cliente() {
    }

    public Cliente(String nome, String sobrenome, String endereco, String email, String DDD, String telefone, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.email = email;
        this.ddd = DDD;
        this.telefone = telefone;
        this.senha = senha;
    }

    public void addReservas(Reserva r){
        reservas.add(r);
    }


}
