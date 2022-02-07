package com.example.appdereservas.services;

import com.example.appdereservas.entities.Gestor;
import com.example.appdereservas.repositories.GestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestorService {

    @Autowired
    private GestorRepository repository;

    public List<Gestor> findAll(){
        return repository.findAll();
    }

    public Gestor findById(Long id){
        Optional<Gestor> obj = repository.findById(id);
        return obj.get();
    }
}
