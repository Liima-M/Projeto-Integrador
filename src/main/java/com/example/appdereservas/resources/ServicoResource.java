package com.example.appdereservas.resources;

import com.example.appdereservas.entities.Cliente;
import com.example.appdereservas.entities.Servico;
import com.example.appdereservas.entities.Servico;
import com.example.appdereservas.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/servicos")
public class ServicoResource {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<Servico> getServico(){
        return  servicoService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Servico findById(@PathVariable Long id){
        return servicoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Servico insert(@RequestBody Servico c){
        return servicoService.insert(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void delete(@PathVariable Long id){
        servicoService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Servico update(@PathVariable Long id, @RequestBody Servico c){
        return c = servicoService.update(id,c);
    }

}
