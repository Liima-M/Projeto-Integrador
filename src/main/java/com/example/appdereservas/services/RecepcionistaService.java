package com.example.appdereservas.services;

import com.example.appdereservas.entities.Recepcionista;
import com.example.appdereservas.repositories.RecepcionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecepcionistaService {

    @Autowired
    private RecepcionistaRepository repository;

    public List<Recepcionista> findAll(){
        return repository.findAll();
    }

    public Recepcionista findById(Long id){
        Optional<Recepcionista> obj = repository.findById(id);
        return obj.get();
    }
}
