package com.example.appdereservas.services;

import com.example.appdereservas.entities.Cliente;
import com.example.appdereservas.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> findAll(){
        return repository.findAll();
    }

    public Cliente findById(Long id){
        Optional<Cliente> obj = repository.findById(id);
        return obj.get();
    }

}
