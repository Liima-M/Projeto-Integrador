package com.example.appdereservas.services;

import com.example.appdereservas.entities.Servico;
import com.example.appdereservas.entities.Servico;
import com.example.appdereservas.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        return obj.orElse(null);


    }

    public Servico insert(Servico s
    ){
        return repository.save(s
        );
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

    public Servico update(Long id, Servico s ){
        try {
            Servico o = repository.getById(id);
            updateData(o,s);
            return repository.save(o);
        }catch (EntityNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    private void updateData(Servico o, Servico s) {
        o.setNome(s.getNome());
        o.setCategoria(s.getCategoria());
        o.setDescricao(s.getDescricao());
        o.setValor(s.getValor());
        o.setReserva(s.getReserva());
    }

}
