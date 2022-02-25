package com.example.appdereservas.services;

import com.example.appdereservas.entities.Carrinho;
import com.example.appdereservas.entities.Cliente;
import com.example.appdereservas.entities.Reserva;
import com.example.appdereservas.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClienteService {


    private ClienteRepository repository;

    private ReservaService reservaService;

    private CarrinhoService carrinhoService;

    public List<Cliente> findAll(){

        return repository.findAll();
    }

    public Cliente findById(Long id){
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElse(null);


    }

    public Cliente insert(Cliente r){
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

    public Cliente update(Long id, Cliente c ){
        try {
            Cliente o = repository.getById(id);
            updateData(o,c);
            return repository.save(o);
        }catch (EntityNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    private void updateData(Cliente o, Cliente c) {
        o.setNome(c.getNome());
        o.setSobrenome(c.getSobrenome());
        o.setEmail(c.getEmail());
        o.setEndereco(c.getEndereco());
        o.setDdd(c.getDdd());
        o.setTelefone(c.getTelefone());
        o.setSenha(c.getSenha());

//        o.setCarrinho(c.getCarrinho());
        o.setReservas(c.getReservas());
    }

    public void bookReserva(Long idReserva, Long idCliente){
        Carrinho carrinho  = new Carrinho();
        carrinhoService.insert(carrinho);
        carrinho = carrinhoService.findById(carrinho.getId());

        Reserva reserva = reservaService.findById(idReserva);
        Cliente cliente = findById(idCliente);

        cliente.addReservas(reserva);
//        cliente.setCarrinho(carrinho);

        reserva.setCliente(cliente);
        reserva.setCarrinho(carrinho);

        carrinho.setCliente(cliente);
        carrinho.addReservas(reserva);

        update(cliente.getId(), cliente);
        reservaService.update(reserva.getId(), reserva);
        carrinhoService.update(carrinho.getId(), carrinho);
    }

}
