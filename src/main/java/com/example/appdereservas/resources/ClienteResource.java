package com.example.appdereservas.resources;

import com.example.appdereservas.entities.Cliente;
import com.example.appdereservas.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;


    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<Cliente> getCliente(){
        return  clienteService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Cliente findById(@PathVariable Long id){
        return clienteService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Cliente insert(@RequestBody Cliente c){
        return clienteService.insert(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void delete(@PathVariable Long id){
       clienteService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente update(@PathVariable Long id, @RequestBody Cliente c){
        return c = clienteService.update(id,c);
    }

    @PutMapping("/reservar/{idReserva}/{idCliente}")
    @ResponseStatus(HttpStatus.OK)
    public void bookReserva( @PathVariable Long idReserva, @PathVariable Long idCliente){
        clienteService.bookReserva(idReserva, idCliente);

    }

}
