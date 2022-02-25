package com.example.appdereservas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nome;
    private String Categoria;
    private String Descricao;
    private Double Valor;

    @JsonIgnore
    @OneToMany ( mappedBy = "servico")
    private List<Reserva> reserva = new ArrayList<>();

//    @ManyToOne
//    @JoinColumn(name = "cliente_id")
//    private Cliente cliente;


    public Servico(){}

    public Servico(String nome, String categoria, String descricao, Double valor) {
        Nome = nome;
        Categoria = categoria;
        Descricao = descricao;
        Valor = valor;
    }

    public Servico(Long id, String nome, String categoria, String descricao, Double valor) {
        this.id = id;
        Nome = nome;
        Categoria = categoria;
        Descricao = descricao;
        Valor = valor;
    }

}
