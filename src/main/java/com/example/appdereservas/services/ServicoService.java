package com.example.appdereservas.services;

import com.example.appdereservas.entities.Servico;
import com.example.appdereservas.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    public List<Servico> findAll(){
        return repository.findAll();
    }

    public Servico findById(Long id){
        Optional<Servico> obj = repository.findById(id);
        return obj.get();
    }
}
