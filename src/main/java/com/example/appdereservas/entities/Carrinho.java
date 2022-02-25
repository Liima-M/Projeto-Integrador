package com.example.appdereservas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Carrinho implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Cliente cliente;

    @JsonIgnore
    @OneToMany (mappedBy = "carrinho")
    private List<Reserva> reservas = new ArrayList<>();

    public void addReservas(Reserva reserva){
        reservas.add(reserva);
    }




}
