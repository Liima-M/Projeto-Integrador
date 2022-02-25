package com.example.appdereservas.services;

import com.example.appdereservas.entities.Gestor;
import com.example.appdereservas.entities.Gestor;
import com.example.appdereservas.repositories.GestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        return obj.orElse(null);


    }

    public Gestor insert(Gestor g){
        return repository.save(g);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            e.printStackTrace();
        } catch (DataIntegrityViolationException e){
            e.printStackTrace();
        }
    }

    public Gestor update(Long id, Gestor g ){
        try {
            Gestor o = repository.getById(id);
            updateData(o,g);
            return repository.save(o);
        }catch (EntityNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    private void updateData(Gestor o, Gestor g) {
        o.setName(g.getName());
        o.setCpf(g.getCpf());
        o.setEmail(g.getEmail());
        o.setEndereco(g.getEndereco());
        o.setSenha(g.getSenha());
    }
}
