package com.example.appdereservas.resources;

import com.example.appdereservas.entities.Cliente;
import com.example.appdereservas.entities.Servico;
import com.example.appdereservas.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/servicos")
public class ServicoResource {

    @Autowired
    private ServicoService service;

    @GetMapping
    public ResponseEntity<List<Servico>> findAll(){
        List<Servico> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Servico> findById(@PathVariable Long id){
        Servico obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
