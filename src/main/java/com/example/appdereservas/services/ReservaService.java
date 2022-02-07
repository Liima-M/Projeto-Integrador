package com.example.appdereservas.services;

import com.example.appdereservas.entities.Reserva;
import com.example.appdereservas.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository repository;

    public List<Reserva> findAll(){
        return repository.findAll();
    }

    public Reserva findById(Long id){
        Optional<Reserva> obj = repository.findById(id);
        return obj.get();
    }
}
