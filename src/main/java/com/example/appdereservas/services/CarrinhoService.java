package com.example.appdereservas.services;

import com.example.appdereservas.entities.Carrinho;
import com.example.appdereservas.repositories.CarrinhoRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CarrinhoService {

    private CarrinhoRepository carrinhoRepository;

    public List<Carrinho> findAll(){

        return carrinhoRepository.findAll();
    }

    public Carrinho findById(Long id){
        Optional<Carrinho> obj = carrinhoRepository.findById(id);
        return obj.orElse(null);


    }

    public Carrinho insert(Carrinho c){
        return carrinhoRepository.save(c);
    }

    public void delete(Long id) {
        try {
            carrinhoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            e.printStackTrace();
        } catch (DataIntegrityViolationException e){
            e.printStackTrace();
        }
    }




    public Carrinho update(Long id, Carrinho c ){
        try {
            Carrinho o = carrinhoRepository.getById(id);
            updateData(o,c);
            return carrinhoRepository.save(o);
        }catch (EntityNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    private void updateData(Carrinho o, Carrinho c) {
        o.setCliente(c.getCliente());
        o.setReservas(c.getReservas());
    }

}
