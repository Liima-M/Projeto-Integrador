package com.example.appdereservas.services;

import com.example.appdereservas.entities.Reserva;
import com.example.appdereservas.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        return obj.orElse(null);


    }

    public Reserva insert(Reserva r){
        return repository.save(r);
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

    public Reserva update(Long id, Reserva r ){
        try {
            Reserva o = repository.getById(id);
            updateData(o,r);
            return repository.save(o);
        }catch (EntityNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    private void updateData(Reserva o, Reserva r) {
        o.setData(r.getData());
        o.setHora(r.getHora());
        o.setCliente(r.getCliente());
        o.setServico(r.getServico());
        o.setCarrinho(r.getCarrinho());
    }
}
