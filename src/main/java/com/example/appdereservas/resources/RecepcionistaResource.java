package com.example.appdereservas.resources;

import com.example.appdereservas.entities.Cliente;
import com.example.appdereservas.entities.Recepcionista;
import com.example.appdereservas.services.RecepcionistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/recepcionistas")
public class RecepcionistaResource {

    @Autowired
    private RecepcionistaService service;

    @GetMapping
    public ResponseEntity<List<Recepcionista>> findAll(){
        List<Recepcionista> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Recepcionista> findById(@PathVariable Long id){
        Recepcionista obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
